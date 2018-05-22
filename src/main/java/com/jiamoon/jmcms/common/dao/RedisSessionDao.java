package com.jiamoon.jmcms.common.dao;

import com.jiamoon.jmcms.common.component.RedisManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RedisManager redisManager;

    /**
     * The Redis key prefix for the sessions
     */
    private static final String KEY_PREFIX = "shiro_:";

    @Override
    public void update(Session session) throws UnknownSessionException {
        //System.out.println("更新session:" + session.getId());
        this.saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        System.out.println("删除session:" + session.getId());
        redisManager.del(KEY_PREFIX + session.getId());
    }

    // 把session对象转化为byte保存到redis中
    public byte[] sessionToByte(Session session) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(session);
            bytes = bo.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    // 把byte还原为session
    public Session byteToSession(byte[] bytes) {
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        SimpleSession session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (SimpleSession) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();
        Set<byte[]> keys = redisManager.keys(KEY_PREFIX + "*");
        if (keys != null && keys.size() > 0) {
            for (byte[] key : keys) {
                //Session s = (Session) SerializerUtil.deserialize(redisManager.get(SerializerUtil.deserialize(key)));
                sessions.add(byteToSession(redisManager.get(new String(key))));
            }
        }
        return sessions;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        System.out.println("创建session:" + session.getId());
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            logger.error("session id is null");
            return null;
        }
        Session session = byteToSession(redisManager.get(KEY_PREFIX + sessionId));
        System.out.println("读取session:" + sessionId);
        return session;
    }

    private void saveSession(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        //设置过期时间
        long expireTime = 1800000l;
        session.setTimeout(expireTime);
        //System.out.println("保存session:" + session.getId());
        redisManager.setEx(KEY_PREFIX + session.getId(), sessionToByte(session), expireTime);
    }

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }
}

package com.yc.qas.conn;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.qas.entity.Appraise;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnectionTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	@Test
	public void testConn() {
		Connection con = null;
		try {
			 con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertNotNull(con);
	}

	
	@Test
	public void testConn02() {
		Connection con = sqlSessionFactory.openSession().getConnection();
		assertNotNull(con);
	}
	
	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;
	@Test
	public void testConn03() {
		RedisConnection con = redisTemplate.getConnectionFactory().getConnection();
		redisTemplate.boundListOps("list").leftPush("adsddfasdf");
		Appraise app = new Appraise();
		
		template.boundListOps("object").rightPush(app);
		assertNotNull(con);
	}
	
	@Test
	public void testConn04() {
		RedisConnection con = jedisConnectionFactory.getConnection();
		//byte[] value = con.get("name".getBytes());
		//System.out.println(new String(value));
		
		RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
		byte[] value = con.get(serializer.serialize("ycname"));
		System.out.println(serializer.deserialize(value));
	}
}

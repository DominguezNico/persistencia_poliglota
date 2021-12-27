package redis_dao;

import redis.clients.jedis.Jedis;

public class ControladorRedis {
	static Jedis jedis;
	public static void conectar() {
		jedis = new Jedis("localhost");
	}
	
	public static void main(String[] args) throws Exception{
		try {
			conectar();
			
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally{

			System.out.println("Conexión Exitosa");
		}
	}
}

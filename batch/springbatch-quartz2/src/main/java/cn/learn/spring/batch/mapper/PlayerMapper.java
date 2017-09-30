package cn.learn.spring.batch.mapper;

import java.util.Map;

import cn.learn.spring.batch.domain.Player;

public interface PlayerMapper {

	int insertPlayer(Player record);
	
	public Player  selectById(Map<String,Object> map) ;  
}

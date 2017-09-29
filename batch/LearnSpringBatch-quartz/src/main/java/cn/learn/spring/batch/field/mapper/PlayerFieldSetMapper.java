package cn.learn.spring.batch.field.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import cn.learn.spring.batch.domain.Player;

public class PlayerFieldSetMapper implements FieldSetMapper<Player> {

	@Override
	public Player mapFieldSet(FieldSet fs) {
		
		if(fs == null){
			return null;
		}
		
		Player player = new Player();
		player.setId(fs.readString("ID"));
		player.setLastName(fs.readString("lastName"));
		player.setFirstName(fs.readString("firstName"));
		player.setPosition(fs.readString("position"));
		player.setDebutYear(fs.readInt("debutYear"));
		player.setBirthYear(fs.readInt("birthYear"));
		
		return player;
	}
	

}


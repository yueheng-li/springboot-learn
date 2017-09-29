package cn.learn.spring.batch.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.learn.spring.batch.domain.Player;
import cn.learn.spring.batch.mapper.PlayerMapper;

public class PlayerItemWriter  implements ItemWriter<Player> {
    private static Log log = LogFactory.getLog(PersonWriter.class);
	
	@Autowired
	public PlayerMapper playerMapper;
 
    @Override
	public void write(List<? extends Player> players) {
        for (Player player : players) {
            log.info("Processing: " + player.toString());
            playerMapper.insertPlayer(player);
		}
    }
}
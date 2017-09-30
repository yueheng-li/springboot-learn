package cn.learn.spring.batch.writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.WriteFailedException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.learn.spring.batch.domain.Player;
import cn.learn.spring.batch.mapper.PlayerMapper;

public class SkipItemWriter  implements ItemWriter<Player> {
    private static Log log = LogFactory.getLog(PersonWriter.class);
    
	@Autowired
	public PlayerMapper playerMapper;

	private List<String> failingPlayer = new ArrayList<String>();
 
    @Override
	public void write(List<? extends Player> players) {
        for (Player player : players) {
            log.info("Processing: " + player.toString());
            if (this.failingPlayer.contains(player.getId())) {
            	throw new WriteFailedException("Something unexpected happened!");
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id", player.getId());
            Player p = playerMapper.selectById(map);
            if (p != null && StringUtils.isNotBlank(p.getId())) {
                playerMapper.insertPlayer(player);
            }
            
		}
    }
    

	/**
	 * Public setter for the the player on which failure should occur.
	 * 
	 */
	public void setFailingPlayer(List<String> failingPlayer) {
		this.failingPlayer = failingPlayer;
	}
}
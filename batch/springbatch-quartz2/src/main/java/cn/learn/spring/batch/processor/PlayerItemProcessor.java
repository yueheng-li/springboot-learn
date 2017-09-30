package cn.learn.spring.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import cn.learn.spring.batch.domain.Player;

/**
 * 把Reader读取的Person内容Upper
 * @author chunhui.li
 *
 */
public class PlayerItemProcessor implements ItemProcessor<Player, Player> {

    private static final Logger log = LoggerFactory.getLogger(PlayerItemProcessor.class);
    
    private int failure = -1;

	private int index = 0;
	
	private Player failedItem = null;

	/**
	 * Public setter for the the index on which failure should occur.
	 * 
	 * @param failure the failure to set
	 */
	public void setValidationFailure(int failure) {
		this.failure = failure;
	}

	@Override
	public Player process(Player item) throws Exception {
		if ((failedItem == null && index++ == failure) || (failedItem != null && failedItem.equals(item))) {
			failedItem = item;
			throw new ValidationException("Some bad data for " + failedItem);
		}
		return item;
	}
}
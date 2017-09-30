package cn.learn.spring.batch.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

import cn.learn.spring.batch.domain.Player;

public class RetryItemWriter  implements ItemWriter<Player> {
    private static Log log = LogFactory.getLog(PersonWriter.class);

	private int counter = 0;
 
    @Override
	public void write(List<? extends Player> players) {
    	int current = counter;
		counter += players.size();
		log.info("write..." + players);
		if (current < 3 && (counter >= 2 || counter >= 3)) {
			log.info("write...IllegalStateException");
			throw new IllegalStateException("Temporary error");
		}
    }

	/**
	 * @return number of times {@link #write(List)} method was called.
	 */
	public int getCounter() {
		return counter;
	}

}
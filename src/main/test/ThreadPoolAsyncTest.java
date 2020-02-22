import com.you.async.service.OrderTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/***
 * ThreadPoolAsyncTest 测试类
 *
 * @author: You
 * @date: 2020/2/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class ThreadPoolAsyncTest {

    @Autowired
    private OrderTaskService orderTaskService;

    /**
     * 测试方式二：手动获取实例
        private final ApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
     *
     */

    @Test
    public void test() throws ExecutionException {
        try {
            //测试方式二：手动获取实例
            //OrderTaskService orderTaskService = applicationContext.getBean(OrderTaskService.class);
            orderTaskService.cancelOrderTask();
            //不让主线程过早结束，否则控制台看不到异步方法中的输出内容
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

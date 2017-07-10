package swtsample;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yc.utils.Common;

public class TestCommon {

	@Test
	public void testLog4() {
		Common.log.fatal("这是一个致命的错误信息");
		Common.log.error("错误信息");
		Common.log.info("普通信息");
		Common.log.debug("调试错误");
	}

}

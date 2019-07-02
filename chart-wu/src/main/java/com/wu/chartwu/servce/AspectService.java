package com.wu.chartwu.servce;

import com.wu.chartwu.anno.DemoAn;
import org.springframework.stereotype.Service;

@Service
public class AspectService {
	@DemoAn("s")
	public void tt(){
		System.out.println(1232);
	}
}

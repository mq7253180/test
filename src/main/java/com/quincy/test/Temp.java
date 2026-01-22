package com.quincy.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.quincy.test.auto.FooTemplate;

public class Temp {

	public static void main(String[] args) {
		FooTemplate t0 = new FooTemplate();
		t0.setName("aaa");
		FooTemplate t1 = new FooTemplate();
		t1.setName("bbb");
		FooTemplate t2 = new FooTemplate();
		t2.setName("ccc");
		System.out.println(t0.hashCode());
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        t2.setName("ddd");
        System.out.println(t2.hashCode());
        Connection conn = null;
        try {
			PreparedStatement s = conn.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

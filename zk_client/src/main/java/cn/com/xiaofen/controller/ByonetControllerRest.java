package cn.com.xiaofen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.xiaofen.bean.Byonet;

@RestController
public class ByonetControllerRest {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/byonetList")
	public List<Byonet> byonetList() {
		String sql = "select kkid,kkmc,x,y from t_itgs_tgsinfo";
		BeanPropertyRowMapper<Byonet> rowMapper = new BeanPropertyRowMapper<Byonet>(Byonet.class);
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@RequestMapping("/byonetList/{kkid}")
	public List<Byonet> byonetListById(@PathVariable(required=true,name="kkid")String kkid) {
		String sql = "select kkid,kkmc,x,y from t_itgs_tgsinfo where kkid=?";
		BeanPropertyRowMapper<Byonet> rowMapper = new BeanPropertyRowMapper<Byonet>(Byonet.class);
		return jdbcTemplate.query(sql, rowMapper,kkid);
	}
}

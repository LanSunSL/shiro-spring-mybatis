package cn.mldn.shiro.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.mldn.shiro.service.IEmpService;
@Service
public class EmpServiceImpl implements IEmpService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean add() {
		this.log.info("************** [EmpService.add()] **************");
		return false;
	}

	@Override
	public boolean edit() {
		this.log.info("************** [EmpService.edit()] **************");
		return false;
	}

	@Override
	public boolean delete() {
		this.log.info("************** [EmpService.delete()] **************");
		return false;
	}

}

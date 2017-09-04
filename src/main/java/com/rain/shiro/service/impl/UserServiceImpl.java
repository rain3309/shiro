package com.rain.shiro.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.shiro.common.service.BaseServiceImpl;
import com.rain.shiro.core.security.Digests;
import com.rain.shiro.domain.User;
import com.rain.shiro.domain.UserDetail;
import com.rain.shiro.repository.UserDao;
import com.rain.shiro.service.MemberGroupService;
import com.rain.shiro.service.OrgService;
import com.rain.shiro.service.RoleService;
import com.rain.shiro.service.UserDetailService;
import com.rain.shiro.service.UserMemberGroupService;
import com.rain.shiro.service.UserOrgService;
import com.rain.shiro.service.UserRoleService;
import com.rain.shiro.service.UserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	
	
	private final static int SALT_SIZE = 8;
	
	@Autowired
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User get(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public User delete(Integer id) {
		User bean = get(id);
		return dao.delete(bean);
	}


	@Override
	public Boolean userExist(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmail(Integer id, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(Integer id, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User check(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public User save(User bean, UserDetail detail, Integer[] roleIds, Integer[] orgIds, Integer[] groupIds,
			Integer orgId, Integer groupId, String ip) {
		bean.setOrg(orgService.get(orgId));
		bean.setGroup(groupService.get(groupId));
		entryptPassword(bean);
		
		return null;
	}

	public String entryptPassword(User bean) {
		byte[] saltBytes = Digests.generateSalt(SALT_SIZE);
		
		return null;
	}
	@Transactional
	public User register(String ip, int groupId, int orgId, String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setType(User.MEMBER);
		
		UserDetail detail = new UserDetail();
		return save(user, detail, null, null, null, orgId, groupId, ip);
	}
	
	private UserDetailService detailService;
	private RoleService roleService;
	private OrgService orgService;
	private MemberGroupService groupService;
	private UserRoleService userRoleService;
	private UserOrgService userOrgService;
	private UserMemberGroupService userGroupService;
	
	@Autowired
	public void setDetailService(UserDetailService detailService) {
		this.detailService = detailService;
	}
	
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@Autowired
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	@Autowired
	public void setGroupService(MemberGroupService groupService) {
		this.groupService = groupService;
	}
	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	@Autowired
	public void setUserOrgService(UserOrgService userOrgService) {
		this.userOrgService = userOrgService;
	}

	@Autowired
	public void setUserGroupService(UserMemberGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}
}

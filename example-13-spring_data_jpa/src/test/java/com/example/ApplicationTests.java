package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		save();

		// 测试findAll, 查询所有记录
		Assert.assertEquals(20, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("AAA006").getAge().longValue());

		// 测试findUserByName1, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUserByName1("AAA006").getAge().longValue());

		// 测试findUserByName2, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUserByName2("AAA006").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("AAA006", userRepository.findByNameAndAge("AAA006", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA002"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(19, userRepository.findAll().size());

		// 测试updateUserById
		Assert.assertEquals(1, userRepository.updateUserById("AAA010", Long.valueOf(10)));

		// 测试updateUserById
		Assert.assertEquals(1, userRepository.updateUserById(100, Long.valueOf(10)));

		// deleteUserByName
		Assert.assertEquals(1, userRepository.deleteUserByName1("AAA013"));

		// deleteUserByName
		Assert.assertEquals(1, userRepository.deleteUserByName2("AAA014"));

		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(1, 10, sort);

		//默认分页
		Page userPage = userRepository.findAll(pageable);
		System.out.println("总数：" + userPage.getTotalElements() + "，共有页数：" + userPage.getTotalPages()
				+ "，本页数据条数：" + userPage.getContent().size());

		//默认分页---JPQL
		Page userPage1 = userRepository.findByName1("AAA", pageable);
		System.out.println("总数：" + userPage1.getTotalElements() + "，共有页数：" + userPage1.getTotalPages()
				+ "，本页数据条数：" + userPage1.getContent().size());

		User findUser = new User();
		findUser.setName("AAA");
		Page userPage2 = userService.getUserListByPage(findUser, pageable);
		System.out.println("总数：" + userPage2.getTotalElements() + "，共有页数：" + userPage2.getTotalPages()
				+ "，本页数据条数：" + userPage2.getContent().size());

	}

	private void save(){
		//单个保存
		userRepository.save(new User("AAA001", 10));
		userRepository.save(new User("AAA002", 20));
		userRepository.save(new User("AAA003", 30));
		userRepository.save(new User("AAA004", 40));
		List<User> users = new ArrayList<User>();
		users.add(new User("AAA005", 50));
		users.add(new User("AAA006", 60));
		users.add(new User("AAA007", 70));
		users.add(new User("AAA008", 80));
		users.add(new User("AAA009", 90));
		users.add(new User("AAA010", 100));
		users.add(new User("AAA011", 110));
		users.add(new User("AAA012", 120));
		users.add(new User("AAA013", 130));
		users.add(new User("AAA014", 140));
		users.add(new User("AAA015", 150));
		users.add(new User("AAA016", 160));
		users.add(new User("AAA017", 170));
		users.add(new User("AAA018", 180));
		users.add(new User("AAA019", 190));
		users.add(new User("AAA020", 200));
		//批量保存
		userRepository.save(users);
	}

}

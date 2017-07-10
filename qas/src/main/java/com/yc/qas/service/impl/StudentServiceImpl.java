package com.yc.qas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yc.qas.entity.EUDataGridList;
import com.yc.qas.entity.Student;
import com.yc.qas.entity.StudentFinalRank;
import com.yc.qas.entity.StudentSelectApprise;
import com.yc.qas.entity.StudentSelectScore;
import com.yc.qas.entity.TreeNode;
import com.yc.qas.mapper.ClassesMapper;
import com.yc.qas.mapper.StudentMapper;
import com.yc.qas.service.StudentService;
import com.yc.qas.util.Encrypt;

@Service("studentLoginService")
public class StudentServiceImpl implements StudentService {

	@Resource(name="studentMapper")
	private StudentMapper studentMapper;
	@Resource(name="classesMapper")
	private ClassesMapper classesMapper;

	@Override
	public Student login(Student student) {
		student.setsPwd(Encrypt.md5AndSha(student.getsPwd()));
		return studentMapper.findStudentByStudent(student);
	}

	@Override
	public boolean changePwd(String sPwd, int sNo) {
		String newPwd = Encrypt.md5AndSha(sPwd);
		return studentMapper.changePwd(newPwd, sNo);
	}

	@Override
	public List<TreeNode> selcetSIdByClassId(int id) {
		return studentMapper.selcetSIdByClassId(id);
	}

	@Override
	public EUDataGridList<StudentSelectApprise> studentSelectAllAppraise(
			int studentSno, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<StudentSelectApprise> list = studentMapper.studentSelectAllAppraise(studentSno);
		PageInfo<StudentSelectApprise> pageinfo = new PageInfo<StudentSelectApprise>(list);

		EUDataGridList<StudentSelectApprise> data = new EUDataGridList<StudentSelectApprise>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}

	@Override
	public EUDataGridList<StudentSelectScore> studentSelectAllScore(int studentSno, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<StudentSelectScore> list = studentMapper.studentSelectAllScore(studentSno);
		PageInfo<StudentSelectScore> pageinfo = new PageInfo<StudentSelectScore>(list);

		EUDataGridList<StudentSelectScore> data = new EUDataGridList<StudentSelectScore>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}

	@Override
	public EUDataGridList<StudentFinalRank> studentFinalRank(int studentSno,
			int page, int rows) {
		PageHelper.startPage(page, rows);
		List<StudentFinalRank> list=studentMapper.studentFinalRank(studentSno);
		PageInfo<StudentFinalRank> pageinfo = new PageInfo<StudentFinalRank>(list);
		EUDataGridList<StudentFinalRank> data = new EUDataGridList<StudentFinalRank>();
		data.setTotal(pageinfo.getTotal());
		data.setRows(list);
		return data;
	}

}

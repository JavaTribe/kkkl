/*
 * Copyright (c) 2015 
 * 蓝盾信息安全技术股份有限公司(Bluedon Information Security Technologies Co.,Ltd)
 * All rights reserved.
 */
package com.bluedon.cb.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bluedon.cb.common.exmapper.ExDepartmentMapper;
import com.bluedon.cb.common.pojo.DepartmentTree;

/**
 * Description:部门树工具类.
 * Time:2015年12月4日下午4:21:56
 * @version 1.0
 * @since 1.0
 * @author chenchengteng
 */
@Component
public class DepartmentTreeUtil {
	
	/** 部门树Mapper. */
	@Resource
	private ExDepartmentMapper exDepartmentMapper;
	
	/** 整个部门树 */
	private static  DepartmentTree departmentTree =new DepartmentTree();
	
	/** 父部门IdList. */
	private static List<Integer> parentIdList = new ArrayList<Integer>();
	
	/**
	 * 初始化部门树.
	 */
	@PostConstruct
	public void init() {
		reloadDepartmentTree(exDepartmentMapper);
	}

	/**
	 * reload部门树.
	 * @param departmentTreeMapper 部门树Mapper
	 */
	public static void reloadDepartmentTree(ExDepartmentMapper departmentTreeMapper) {
		departmentTree = departmentTreeMapper.selectDepartmentTree();
		
	}
	
	/**根据部门Id查询目标级别DepartmentTreeList.
	 * 如果目标级别就是当前部门Id级别，则返回List中只有当前部门.
	 * 如果目标级别小于当前部门Id级别,则返回List中只有对应级别的父部门.
	 * 如果目标级别大于当前部门Id级别，则返回List中有所有对应级别的子部门.
	 * @param currentDepaId 当前部门Id
	 * @param targetGradeNo 目标级别
	 * @return
	 */
	public static List<DepartmentTree> getGradeDepartmentTrees(int currentDepaId, int targetGradeNo){
		List<DepartmentTree> departmentTreeList = new ArrayList<DepartmentTree>();
		DepartmentTree cuurentDepartmentTree = getDepartmentTreeByDepaId(currentDepaId, DepartmentTreeUtil.departmentTree);
		int currentGradeNo = cuurentDepartmentTree.getGradGradeNo();
		if(currentGradeNo == targetGradeNo) {
			departmentTreeList.add(cuurentDepartmentTree);
			return departmentTreeList;
		} else if (currentGradeNo > targetGradeNo) {
			departmentTreeList.add(getParent(currentDepaId, targetGradeNo));
			return departmentTreeList;
		} else {
			departmentTreeList=getDepartmentTreeByDepaId(cuurentDepartmentTree, targetGradeNo);
			return departmentTreeList;
		}
	}
	/**
	 * 根据部门Id,查找直属父部门Id.
	 * @param depaId 部门Id
	 * @return 直属父部门Id
	 */
	public static Integer getParentId(int depaId) {
		return getParentId(depaId, -1);
	}
	/**
	 * 根据子部门Id和级别,查找对应级别的父部门Id.
	 * @param depaId 部门Id
	 * @param parentGradeNo 级别编号
	 * @return 对应级别的父部门Id
	 */
	public static Integer getParentId(int depaId, int parentGradeNo) {
		DepartmentTree parentDepartmentTree = getParent(depaId, parentGradeNo);
		if (parentDepartmentTree != null) {
			return parentDepartmentTree.getDepaId();
		} else {
			return null;
		}
	}
	/**
	 * 根据部门Id和级别,查找对应级别的父部门Id集合,集合按照父部门->父部门->父部门 排序.
	 * @param depaId 部门Id
	 * @param parentGradeNo 级别编号
	 * @return 对应级别的父部门Id集合
	 */
	public static List<Integer> getParentIds(int depaId, int parentGradeNo) {
		getParent(depaId, parentGradeNo);
		return parentIdList;
	}
	
	
	/**
	 * 根据部门Id,查找直属父部门实体.
	 * @param depaId 部门Id
	 * @return 直属父部门
	 */
	public static DepartmentTree getParent(int depaId) {
		return getParent(depaId, -1);
	}
	
	/**
	 * 根据部门Id和级别,查找对应级别的父部门实体.
	 * @param depaId 部门Id
	 * @param parentGradeNo 级别编号
	 * @return 对应级别的父部门实体
	 */
	public static DepartmentTree getParent(int depaId, int parentGradeNo) {
		DepartmentTree departmentTree = getDepartmentTreeByDepaId(depaId, DepartmentTreeUtil.departmentTree);
		if (departmentTree != null) {
			int gradGradeNo = departmentTree.getGradGradeNo();
			if (parentGradeNo == -1) {
				return getParentDepartmentTree(departmentTree);
			} else if (parentGradeNo < gradGradeNo) {
				parentIdList.clear();
				for (int i = 0; i < gradGradeNo - parentGradeNo; i++) {
					departmentTree = getParentDepartmentTree(departmentTree);
					parentIdList.add(departmentTree.getDepaId());
				}
				return departmentTree;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 根据部门Id和级别,查找对应级别的父部门实体.
	 * @param depaId 部门Id
	 * @param parentGradeNo 级别编号
	 * @return 对应级别的父部门实体
	 */
	public static DepartmentTree getParent(int depaId, int parentGradeNo, short year) {
		DepartmentTree departmentTree = getDepartmentTreeByDepaId(depaId, DepartmentTreeUtil.departmentTree);
		if (departmentTree != null) {
			int gradGradeNo = departmentTree.getGradGradeNo();
			if (parentGradeNo == -1) {
				return getParentDepartmentTree(departmentTree);
			} else if (parentGradeNo < gradGradeNo) {
				parentIdList.clear();
				for (int i = 0; i < gradGradeNo - parentGradeNo; i++) {
					departmentTree = getParentDepartmentTree(departmentTree);
					parentIdList.add(departmentTree.getDepaId());
				}
				return departmentTree;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * 根据部门Id,查找所有父部门实体.
	 * @param depaId 部门Id
	 * @return 所有父部门实体List
	 */
	public static List<DepartmentTree> getAllParent(int depaId) {
		DepartmentTree departmentTree = getDepartmentTreeByDepaId(depaId, DepartmentTreeUtil.departmentTree);
		List<DepartmentTree> departmentTrees=new ArrayList<DepartmentTree>();
		int gradGradeNo = departmentTree.getGradGradeNo();
		departmentTrees.add(departmentTree);
		DepartmentTree temp=departmentTree;
		for (int i = 0; i < gradGradeNo - 1; i++) {
			temp = getParentDepartmentTree(temp);
			departmentTrees.add(temp);
		}
		return departmentTrees;
	}
	
	/**
	 * 根据部门Id,查找所有父部门实体.
	 * By HONG
	 * 2015-10-30
	 * 
	 * @param depaId 部门Id
	 * @return 所有父部门实体List
	 */
	public static List<DepartmentTree> getAllParent(int depaId, Short year) {
//		short currentYear=SessionPropertyUtil.getCurrentYear();
		DepartmentTree departmentTree = getDepartmentTreeByDepaId(depaId, DepartmentTreeUtil.departmentTree);
		List<DepartmentTree> departmentTrees=new ArrayList<DepartmentTree>();
		int gradGradeNo = departmentTree.getGradGradeNo();
		departmentTrees.add(departmentTree);
		DepartmentTree temp=departmentTree;
		for (int i = 0; i < gradGradeNo - 1; i++) {
			temp = getParentDepartmentTree(temp);
			departmentTrees.add(temp);
		}
		return departmentTrees;
	}
	
	/**根据部门Id，返回由父部门节点拼接成的Path,
	 * @param depaId 部门Id
	 * @return
	 */
	public static String getPathByDepaId(int depaId){
		StringBuilder stringBuilder=new StringBuilder();
		List<DepartmentTree> list=getAllParent(depaId);
		//倒序List
		Collections.reverse(list);
		for (Iterator<DepartmentTree> iterator = list.iterator(); iterator.hasNext();) {
			DepartmentTree departmentTree = (DepartmentTree) iterator.next();
			stringBuilder.append(File.separator).append(departmentTree.getDepaNo());
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 根据部门Id，返回由父部门节点拼接成的Path. 
	 * By HONG 
	 * 2015-10-30
	 * 
	 * @param depaId 部门Id
	 * @return
	 */
	public static String getPathByDepaId(int depaId, Short year){
		StringBuilder stringBuilder=new StringBuilder();
		List<DepartmentTree> list=getAllParent(depaId, year);
		//倒序List
		Collections.reverse(list);
		for (Iterator<DepartmentTree> iterator = list.iterator(); iterator.hasNext();) {
			DepartmentTree departmentTree = (DepartmentTree) iterator.next();
			stringBuilder.append(File.separator).append(departmentTree.getDepaNo());
		}
		return stringBuilder.toString();
	}
	
	
	/**
	 * 根据部门Id,查找子部门集合.
	 * @param depaId 部门Id
	 * @return 子部门集合
	 */
	public static List<DepartmentTree> getChildDepartmentTrees(int depaId){
		DepartmentTree departmentTree=getDepartmentTreeByDepaId(depaId,DepartmentTreeUtil.departmentTree);
		if (departmentTree != null) {
			return getChildDepartmentTree(departmentTree);
		} else {
			return null;
		}
	}
	
	/**
	 * @param depaId 当前部门Id
	 * @return 当前部门的子部门depaId
	 */
	public static List<Integer> getChildDepartmentTreeDepaIds(int depaId) {
		List<Integer> depaIds=new ArrayList<Integer>();
		List<DepartmentTree> chlidDepartmentTrees=getChildDepartmentTrees(depaId);
		for (DepartmentTree departmentTree : chlidDepartmentTrees) {
			 depaIds.add(departmentTree.getDepaId());
		}
		return depaIds;
	}
	
	/**
	 * 根据当前部门Id和年份，获得当前部门的子部门Id列表.
	 * @param depaId 当前部门id
	 * @param year 年份
	 * @return
	 */
	public static List<Integer> getChildDepartmentTreeDepaIds(Integer depaId, Short year){
		List<Integer> depaIds=new ArrayList<Integer>();
		DepartmentTree departmentTree = getDepartmentTreeByDepaId(depaId, DepartmentTreeUtil.departmentTree);
		
		if (departmentTree != null) {
			for(DepartmentTree dtree : departmentTree.getChildList()){
				depaIds.add(dtree.getDepaId());
			}
			return depaIds;
		} else {
			return null;
		}
	}
	
	/**
	 * 获取当前部门树的所有节点
	 * @param departmentTree
	 * @return 部门ID List
	 */
	public static List<Integer> getAllChildDepartmentDepaIds(DepartmentTree departmentTree) {
		
		List<Integer> depaIds=new ArrayList<Integer>();
		List<DepartmentTree> childList = departmentTree.getChildList();
		if(childList.size()>0){
			for (DepartmentTree tempDepartmentTree : childList) {
				List<Integer> childDepaIdList=getAllChildDepartmentDepaIds(tempDepartmentTree);
				if(childDepaIdList.size()>0){
					depaIds.addAll(childDepaIdList);
				}
				depaIds.add(tempDepartmentTree.getDepaId());
			}
		} 
		return depaIds;
		
	}
	/**
	 * 根据子部门Id，在整个部门中递归查找子部门.
	 * @param depaId  部门Id
	 * @param departmentTree 整个部门
	 * @return 子部门实体
	 */
	public static DepartmentTree getDepartmentTreeByDepaId(int depaId,DepartmentTree departmentTree){
		DepartmentTree targetDepartmentTree = null;
		if (departmentTree.getDepaId() == depaId) {
			targetDepartmentTree = departmentTree;
			return targetDepartmentTree;
		} else {
			 List<DepartmentTree> childList = departmentTree.getChildList();
			if (childList.size() > 0) {
				for (DepartmentTree childDepartmentTree : childList) {
					targetDepartmentTree = getDepartmentTreeByDepaId(depaId, childDepartmentTree);
					if (targetDepartmentTree != null) {
						break;
					}
				}
				return targetDepartmentTree;
			}
			return null;
		}
	}
	
	/**
	 * 根据部门Id,获取当前部门Tree
	 * @param depaId
	 * @return
	 */
	public static DepartmentTree getDepartmentTreeByDepaId(int depaId) {
		return getDepartmentTreeByDepaId(depaId,departmentTree);
	}
	
	/**
	 * 根据部门Id和年份,获取当前部门Tree
	 * @param depaId 当前部门id
	 * @return
	 */
	public static DepartmentTree getDepartmentTreeByDepaId(Integer depaId) {
		return getDepartmentTreeByDepaId(depaId,departmentTree);
	}

//	/**
//	 * 根据部门Id,和年份获取当前部门Tree
//	 * @param depaId
//	 * @param year 年份
//	 * @return
//	 */
//	public static DepartmentTree getDepartmentTreeByDepaId(int depaId, short year) {
//		return getDepartmentTreeByDepaId(depaId,departmentTreeMap.get(year));
//	}

	/**
	 * 根据父部门Tree，查找对应级别的所有子部门Tree.
	 * @param departmentTree 父部门Tree
	 * @param targetGradeNo	子部门级别
	 * @return
	 */
	public static List<DepartmentTree> getDepartmentTreeByDepaId(DepartmentTree departmentTree, int targetGradeNo) {
		List<DepartmentTree> childDepartmentTreeList = new ArrayList<DepartmentTree>();
		List<DepartmentTree> currentChildDepartmentTreeList= departmentTree.getChildList();
		for (DepartmentTree childDepartmentTree : currentChildDepartmentTreeList) {
			if (childDepartmentTree.getGradGradeNo() == targetGradeNo) {
				childDepartmentTreeList.addAll(currentChildDepartmentTreeList);
				return childDepartmentTreeList;
			} else {
				childDepartmentTreeList.addAll(getDepartmentTreeByDepaId(childDepartmentTree, targetGradeNo));
			}
		}
		return  childDepartmentTreeList;
	}
	/**
	 * 获取父部门实体.
	 * @param departmentTree 部门实体
	 * @return 父部门实体
	 */
	private static DepartmentTree getParentDepartmentTree(DepartmentTree departmentTree) {
		return departmentTree.getParent();
	}
	/**
	 *获取子部门集合.
	 * @param departmentTree 部门实体
	 * @return 子部门集合
	 */
	private static List<DepartmentTree> getChildDepartmentTree(DepartmentTree departmentTree) {
		return departmentTree.getChildList();
	}

	public ExDepartmentMapper getCommonDepartmentTreeMapper() {
		return exDepartmentMapper;
	}

	public void setCommonDepartmentTreeMapper(
			ExDepartmentMapper exDepartmentMapper) {
		this.exDepartmentMapper = exDepartmentMapper;
	}

	public static DepartmentTree getDepartmentTree() {
		return departmentTree;
	}

	public static void setDepartmentTreeMap(
			 DepartmentTree departmentTree) {
		DepartmentTreeUtil.departmentTree = departmentTree;
	}
	
	/**
	 * 根据当前部门id和需要查询的年份，查找出该部门在所在年份对应的部门id.
	 * @param year 年份
	 * @param currentDepaId 当前部门id
	 * @return 所在年份对应的部门id
	 */
	public static int getDepartmentIdByYear(short year, int currentDepaId){
		DepartmentTree currentDepartmentTree = getDepartmentTreeByDepaId(currentDepaId);
		DepartmentTree targetDepartmentTree =departmentTree;
		
		if(currentDepartmentTree != null && targetDepartmentTree != null){
			DepartmentTree departmentTree = getDepartmentTreeByDepaNo(currentDepartmentTree.getDepaNo(), targetDepartmentTree);
			if(departmentTree != null){
				return departmentTree.getDepaId();
			} 
		}
		
		return -1;
		
	}
	
	/**
	 * 根据子部门编号，在整个部门中递归查找子部门.
	 * @param depaNo  部门编号
	 * @param departmentTree 整个部门
	 * @return 子部门实体
	 */
	public static DepartmentTree getDepartmentTreeByDepaNo(String depaNo, DepartmentTree departmentTree){
		DepartmentTree targetDepartmentTree = null;
		if (departmentTree.getDepaNo().equals(depaNo)) {
			targetDepartmentTree = departmentTree;
			return targetDepartmentTree;
		} else {
			 List<DepartmentTree> childList = departmentTree.getChildList();
			if (childList.size() > 0) {
				for (DepartmentTree childDepartmentTree : childList) {
					targetDepartmentTree = getDepartmentTreeByDepaNo(depaNo, childDepartmentTree);
					if (targetDepartmentTree != null) {
						break;
					}
				}
				return targetDepartmentTree;
			}
			return null;
		}
	}
}

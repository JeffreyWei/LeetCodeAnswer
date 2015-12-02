package com.wei.leetcodeanswer.addtwonum;

/**
 * Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 相当于342+465=807
 * Created by wei on 15/12/2.
 */
public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode num2 = new ListNode(2);
		ListNode num4 = new ListNode(4);
		ListNode num3 = new ListNode(3);
		num2.next = num4;
		num4.next = num3;

		ListNode num5 = new ListNode(5);
		ListNode num6 = new ListNode(6);
		ListNode _num4 = new ListNode(4);
		num5.next = num6;
		num6.next = _num4;

		solution.addTwoNumbers(num2, num5);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		ListNode head = new ListNode(tmp1.val + tmp2.val);
		ListNode current = head;
		tmp1 = tmp1.next;
		tmp2 = tmp2.next;
		boolean addFlag = false;
		while (tmp1 != null || tmp2 != null) {
			int sum = 0;
			if (addFlag) {
				sum = 1;
				addFlag = false;
			}
			if (tmp1 == null) {
				sum = tmp2.val;
			} else if (tmp2 == null) {
				sum = tmp1.val;
			} else {
				sum += tmp1.val + tmp2.val;
			}
			if (sum >= 10) {
				sum -= 10;
				addFlag = true;
			}
			current.next = new ListNode(sum);
			current = current.next;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		if (addFlag) {
			current.next = new ListNode(1);
		}
		return head;
	}
}

class ListNode {
	public ListNode next;
	int val;

	ListNode(int x) {
		val = x;
	}
}

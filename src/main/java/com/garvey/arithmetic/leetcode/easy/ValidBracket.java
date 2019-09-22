package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;
import java.util.Stack;

/**
 * @Description 有效的括号
 *  1.左括号必须用相同类型的右括号闭合。
 *  2.左括号必须以正确的顺序闭合。
 * @Author Garvey
 * @Date 2019-09-22 21:38
 */
public class ValidBracket {

    /**
     * 是否为有效字符串（注意空字符串可被认为是有效字符串）
     * @param s     s只包括 '('，')'，'{'，'}'，'['，']'
     * @return
     */
    public boolean isValid(String s) {
        if (Objects.isNull(s)) {
            return true;
        }

        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            if (s.contains("{}")) {
                s = s.replace("{}","");
            }
            if (s.contains("()")) {
                s = s.replace("()","");
            }
            if (s.contains("[]")) {
                s = s.replace("[]","");
            }
        }

        return s.isEmpty();
    }

    /**
     * 是否为有效字符串（注意空字符串可被认为是有效字符串）
     * @param s     s只包括 '('，')'，'{'，'}'，'['，']'
     * @return
     */
    public boolean isValidV2(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return true;
        }

        if ((s.length() & 1) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();

        int i = 0;
        boolean valid = true;

        while (valid && i < brackets.length) {
            if (stack.isEmpty()) {
                if (brackets[i] != '(' && brackets[i] != '{' && brackets[i] != '[') {
                    valid = false;
                } else {
                    stack.push(brackets[i]);
                }
            } else {
                if (brackets[i] == ')') {
                    if (stack.peek() != '(') {
                        valid = false;
                    } else {
                        stack.pop();
                    }
                } else if (brackets[i] == '}') {
                    if (stack.peek() != '{') {
                        valid = false;
                    } else {
                        stack.pop();
                    }
                } else if (brackets[i] == ']') {
                    if (stack.peek() != '[') {
                        valid = false;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(brackets[i]);
                }
            }
            i++;
        }

        return valid && stack.isEmpty();
    }
}

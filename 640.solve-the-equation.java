/*
 * @lc app=leetcode id=640 lang=java
 *
 * [640] Solve the Equation
 *
 * https://leetcode.com/problems/solve-the-equation/description/
 *
 * algorithms
 * Medium (41.27%)
 * Likes:    205
 * Dislikes: 472
 * Total Accepted:    22.2K
 * Total Submissions: 53.9K
 * Testcase Example:  '"x+5-3+x=6+x-2"'
 *
 * 
 * Solve a given equation and return the value of x in the form of string
 * "x=#value". The equation contains only '+', '-' operation, the variable x
 * and its coefficient.
 * 
 * 
 * 
 * If there is no solution for the equation, return "No solution".
 * 
 * 
 * If there are infinite solutions for the equation, return "Infinite
 * solutions".
 * 
 * 
 * If there is exactly one solution for the equation, we ensure that the value
 * of x is an integer.
 * 
 * 
 * Example 1:
 * 
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "x=x"
 * Output: "Infinite solutions"
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "2x=x"
 * Output: "x=0"
 * 
 * 
 * 
 * Example 4:
 * 
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * 
 * 
 * 
 * Example 5:
 * 
 * Input: "x=x+2"
 * Output: "No solution"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String solveEquation(String equation) {
        int dividend = 0;
        int divisor = 0;
        int flag = 1;
        int symbol = flag;
        String str = "";

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                if (str != "") {
                    dividend += Integer.parseInt(str) * symbol;
                    str = "";
                }
                flag = -1;
                symbol = flag;
            } else if (equation.charAt(i) == '-') {
                if (str != "") {
                    dividend += Integer.parseInt(str) * symbol;
                    str = "";
                }
                symbol = -flag;
            } else if (equation.charAt(i) == '+') {
                if (str != "") {
                    dividend += Integer.parseInt(str) * symbol;
                    str = "";
                }
                symbol = flag;
            } else if (equation.charAt(i) == 'x') {
                if (str.length() == 0) {
                    divisor -= symbol;
                } else {
                    divisor -= Integer.parseInt(str) * symbol;
                    str = "";
                }
            } else {
                str += String.valueOf(equation.charAt(i));
            }

            if (i == equation.length() - 1 && equation.charAt(i) != 'x') {
                dividend += Integer.parseInt(str) * symbol;
            }
        }

        if (dividend == 0 && divisor == 0) {
            return "Infinite solutions";
        } else if (divisor == 0) {
            return "No solution";
        } else {
            return "x=" + Integer.toString(dividend / divisor);
        }
    }
}
// @lc code=end

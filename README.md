# CodingInterviews - 《剑指offer》java代码
1. 习题对应的书本版本是2017年出版的《剑指offer》第二版
2. 代码在codingInterview_coding/src下
3. 命名： 如T03_1_xxx，T03为书中对应题号，_1为题号下第一小题

## 目录

* [第二章](/codingInterview_coding/src/chapter2):  T1-15

* [第三章](/codingInterview_coding/src/chapter3):  T16-26
* [第四章](/codingInterview_coding/src/chapter4):  T27-38
* [第五章](/codingInterview_coding/src/chapter5):  T39-52
* [第六章](/codingInterview_coding/src/chapter6):  T53-66



## 总结

#### 二分法和分治策略

1. [T03-2](/codingInterview_coding/src/chapter2)：不修改数组，找出数组中重复的数字
   * 确定一个中间元素t，然后统计1-t的元素的个数，若个数>t，则一定有重复的，就继续二分这一段，直到end=start
2. [T11](/codingInterview_coding/src/chapter2)：旋转数组的最小值（要求运用旋转数组的特点）
   * 根据旋转数组的特点，二分法得到的mid元素若大于a[start]，说明min再后半段，若小于则在前半段
   * 但是注意有可能这个旋转数组特殊，1. 就是一个普通的递增数组，2. 如test2中的多重复元素的数组。需要分别处理

#### 动态规划

1. [T10](/codingInterview_coding/src/chapter2)：求斐波那契数列的第n项。	可以将这个问题以及其衍生：跳台阶问题、矩形覆盖问题，看作一种简单动态规划，满足关系：$f(n) = f(n-1) + f(n-2)$
2. [T14](/codingInterview_coding/src/chapter2)：剪绳子，长度为n的绳子，剪成m段（m，n都是整数且都大于1），求剪出来各段绳子的长度的乘积最大是多少？
   * 动态规划，$f(n)$表示长度为$n$的切割各段乘积最大值，$f(n)=max[f(i)\times f(n-i)]$

#### 回溯法

1. [T12](/codingInterview_coding/src/chapter2)：矩阵中的路径， 设计函数判断：一个矩阵中是否存在一条包含某字符串的所有字符的路径。
   * 典型回溯法
2. [T13](/codingInterview_coding/src/chapter2)：机器人的运动范围。m*n方格，机器人从(0,0)开始，每次上下左右四个方向，但不能进入行坐标和列坐标的数位之和大于k的格子。求机器人最多能到达多少个格子？
   * 典型回溯法
3. 

#### 双指针/三指针

1. [T05-1](/codingInterview_coding/src/chapter2)：将字符串中空格替换为%20
   * 先遍历找空格的个数，由此得到替换后的字符串总长度
   * 然后使用双指针p1，p2，分别指向原字符串末尾和替换后的字符串末尾，向前遍历
   * p1前移，逐个将非空格字符复制到p2所在处，p2也前移。若p1碰到空格，则连续复制%20到p2处
2. [T05-2](/codingInterview_coding/src/chapter2)：两个排序的数组A1和A2，A1末尾有足够多空余空间容纳A2，合并这两个数组，形成有序数组
   * 先计算出合并后A1的长度，然后按照归并排序+三指针（分别指向原A1尾，原A2尾，合并后应形成的数组尾）的思想进行合并即可

#### 数据结构—树

1. [T07](/codingInterview_coding/src/chapter2)：根据先序和中序遍历的序列，重构二叉树
   * 根据先序遍历可以直接确定根，然后根据根在中序遍历中的位置，可以确定根的左右子树，进行递归
2. [T08](/codingInterview_coding/src/chapter2)：树的结构：有左右子树，还有一个指向父节点的指针，求二叉树中序遍历序列中的下一个节点
   * 右子树不为空，则下一个节点是右子树的最左子树
   * 右子树为空，且父指针节点的左子树是自己，则下一个节点是父指针指向的节点
   * 右子树为空，且父指针节点的右子树是自己，则下一个节点某个祖先节点的父节点，且满足该祖先节点是其父节点的左子树

#### 数据结构—链表



#### 数据结构—栈和队列

1. [T06](/codingInterview_coding/src/chapter2)：链表反置输出		压栈或者递归即可
2. [T09](/codingInterview_coding/src/chapter2)：用两个栈模拟一个队列，实现两个函数appendTail和deleteHead，分别是尾插和头删
   * 尾插：直接插入
   * 头删：设置两个栈，stack1，stack2
     * 若stack2为空，说明之前都是插入操作。于是将stack1的元素依次pop到stack2中，stack2栈顶即是要删除的队首
     * 若stack2不为空，则先将stack2的出栈即可
     * 此时这个队列的顺序从头到尾是：stack2从上到下 ---> stack1 从下到上

#### 数据结构—排序和查找的应用

1. [T03-1](/codingInterview_coding/src/chapter2)：找出数组中重复的数字
   * 不真正的进行排序，而是根据题意：值i一定在第i位上。
   * 故先判断第i位是不是i（即比较`i`和`array[i]`），若不是，则先判断`array[i]`是否等于`array[array[i]]`(因为`i`不等于`array[i]`，这两者在无重复数列中应该也不相等)
   * 如果相等则这就是重复元素，不相等则将两者交换，这样第`array[i]`位上的值就保证在该在的位置上了。这是一种模拟排序的过程
2. [T04](/codingInterview_coding/src/chapter2)： 二维矩阵的查找
   * 从右上角开始逐渐向左下角减小范围，每一次列首或行尾元素和要寻找元素比较，然后剔除一列，或者剔除一行，直至找到该元素
   * 同理也可以从左下角往右上剔除，但是若是从左上和右下角，则比较复杂

#### 位运算

1. [T15](/codingInterview_coding/src/chapter2)：输入一个整数，输出该数二进制表示中1的个数
   * 除了用常规的除以2再移位（逻辑移位），还可以采用特殊办法
   * 一个数n减去1，在二进制中会将最右边的1变成0，且这个1后面的0全变成1。所以等式$ n \& (n-1) $就可以用来消1，每进行一次上述计算即有一个1，直到最后消成全0

#### 贪心思想



#### 滑动窗口



#### 哈希表应用



#### 正则匹配



#### 特殊规律和数学题








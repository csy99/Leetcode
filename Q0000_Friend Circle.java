/***
 * Created by csy99 on 8/1/21.
Amazon is working on grouping people in audible groups. You are given a list of integers which are pictorially repesented as 2D matrix

Input List
110, 110, 001

Return the number of groups

public int groups(List users){

}

Matrix representation
col 0 col1 col2
row 0 1 1 0
row 1 1 1 0
row 2 0 0 1

M[i][j] = 1 represents user a and user b are connected. Each user knows himself
For instance in above example user 0 knows user 0 and 1 so(matrix[0][0] = 0 and matrix[0][1] =1)
Similaraly user 1 knows user 0 and 1so(matrix[1][0] = 0 and matrix[1][1] =1)
user 2 knows no one so matrix[2][2] = 2
Find the number of groups. in this example there are 2 groups {0,1} and {2}

When I saw the question in first pass this seems like number of island question but there was a variation which I didn't pay attention to. The question also said users can be directly known to each other or transitively.

Consider below example which was hidden test case

Matrix representation
col 0 col1 col2 col3
row 0 1 1 0 0
row1 1 1 0 1
row2 0 0 1 0
row3 0 0 0 1

In above case the expected grouping is user 0 knows user 0(himself) and 1
User 1 knows user 0, 1 and in addition knows user 3 since matrix[1][3] = 1 . User 3 is connected to user 1 directly and since user 0 and 1 are connected already, user 3 and user 0 are connected transitively .

In this case also the expected output is 2 groups {0,1,3} and {2} but my code was returing 3 groups {0,1} {2} and {3} . 
 */
 def countGroups(related):
    # Write your code here
    count = 0
    length = len(related)
    related = convertToArray(related)
    
    for indx in range(length):
        if related[indx][indx] == 1:
            count +=1
            dfs(indx, length, related)
    return count

def dfs(idx, length,matrix):
    if matrix[idx][idx] == 0:
        return 
    for i in range(length):
        if matrix[idx][i]==1:
            matrix[idx][i]=0
            dfs(i,length,matrix)
            
            
def convertToArray(s):
    result = []
    for char in s:
        result.append([int(x) for x in char])
    return result    

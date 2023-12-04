# Week 9 - Putting it All Together

# PART 1

# **For this lab report, we are asked to describe a debugging scenario as a conversation on Edstem. It should start with a original post from a student showing a symptom and a description of a guess at some possible bug with some sense of what the failure-inducing input is. It should have a response from a TA asking a leading question or suggesting a command to try. There should be a screenshot/terminal output showing what information the student got from trying the TAs suggestion, and a clear description of what the bug is. It should involve at least a Java file and a bash script. Describing the bug should involve reading some output at the terminal resulting from running one or more commands.

# **1. **

# **2. **

# **3. **

# **4. The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)**

# PART 2

1. find . -name "Chapter*.*" -print

2. find . -type d -print

3. find . -type d -size +1k
   
4. find . -type f -name "chapter*.*" -print
   
5. find . -name "Chapter*.*" -exec wc -l {} \;
   
6. find . -name "*.*" -exec grep -nH "Tuesday, September 11, 2001" {} \;
    
7. find . -name "*.java" -exec grep -nH "Tuesday" {} \;

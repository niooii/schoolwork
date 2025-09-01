

CS310 Coding Project Submission Instructions: Spring 2025

Complete the following steps on a computer in G7 or N01, or on remote.cs.binghamton.edu.

All of the commands below are intended to be one line each... if they wrap, it is because this frame is not wide enough, not because they should be typed on two lines with an <ENTER>.

These instructions turn a github repository directory on the CS machines into a single .tar.gz file with the correct format and naming conventions for submission to Brightspace. We use scripts to unpack, test, and grade your submission; if your file is not named and formatted like all the other students' files, the scripts can break and cause significant inconvenience. To incentivize attention to detail, a few penalty points may be taken off for incorrect naming and submission structures. These instructions are for CP0; for subsequent assignments, replace CP0 with CP1, CP2, etc.

0. Copy the cs310 academic honesty statement into your README.md file.

I have worked on this project individually, and have not given or received too much help. In particular, I have not gained access to any other students' repositories, files, or code, nor have I given any other students access to mine. I have not used generative AI, including but not limited to chatGPT, unless explicitly authorized for this assignment. I understand that my code will be run through a very effective similarity checker, and that academic honesty violations are taken seriously.

1. make clean  (we don’t want any .o’s or executables in the submitted file, please)

This step requires that the clean target be correctly supported by your makefile.

2. git commit and git push your code so that your repo matches your submission. Although we do not grade your repo, this is a required step, because sometimes the grading TA may ask me a question about the code, and I will get it from the repo. This also serves as a backup in case something goes wrong with the Brightspace submission.

3. cd into the directory that contains the repo directory that was created when you cloned the assignment.

Do not remain in, or cd into the repo directory itself; you should be one level “up” from there. The exact directory structure you use on the CS machines doesn’t matter. e.g.:

cd ~/Classes/CS310/CP0

- or -

cd ..  (if you had been in the top level of the repo directory just before this command)

4. Create a .tar archive file

tar -cvf CP0_<Lastname>_<ldapid>_<githubid>.tar <repo-subdirectory-name>

Don’t type the < or > characters; replace what’s between them with your information. For example:

tar -cvf CP0_Andhare_aandhar2_aandhare.tar cs310-spring2025-cp0-aandhare

Andhare is my last name. aandhar2 is my userid on the CS machines. aandhare is my GitHub userid. cs310-spring2025-cp0-aandhare is the name of the directory that contains my repo for CP0.

5. Create a .gz file from the .tar file

gzip CP0_<Lastname>_<ldapid>_<githubid>.tar

No need to name the .gz file explicitly; it will be created properly automatically. e.g.:

gzip CP0_Andhare_aandhar2_aandhare.tar

6. Confirm that the .gz file is not empty!
ls -l *.tar.gz

Sample output from this command (20327 is the number of bytes, make sure it’s not 0):

-rw-r----- 1 [...] 20327 Jan 27 11:26 CP0_Andhare_aandhar2_aandhare.tar.gz

7. Upload CP0_<Lastname>_<ldapid>_<githubid>.tar.gz to Brightspace, under the Assignments tab

If you’re sitting at a computer in G7 or N01, you can use a browser to upload directly. If you created the .gz file by logging into remote.cs.binghamton.edu, then you’ll have to get it onto your computer before uploading. One way to do so is with the “secure copy” scp command, available from a linux shell or Windows power shell. e.g.:

scp aandhar2@remote.cs.binghamton.edu:~/Classes/CS310/CP0/CP0_Andhare_aandhar2_aandhare.tar.gz .

Don’t forget the . at the end, and make sure you’re running this from within a shell on your own machine, not from within a shell on remote.cs.binghamton.edu. This scp command, with the . as the destination in 2nd command line argument, will give the local file the same name it had on remote.cs, and will download the file into the folder/directory from which it is run (so make note of that so you can find it when uploading using your browser).

I will put this procedure in a makefile rule for future assignments; but these instructions will work in the meantime.

Submission Penalty Points

With every assignment, we may take off Submission Penalty Points from submissions that do not adhere to the submission standards. With so many students and automated grading tools, we use this to ensure that submissions are uniform and our scripts and processes run smoothly. We also take Late Penalty Points for submissions that arrive after the deadline.

Submission Penalty Points

Tar File Name: 2 points - the name of the submitted file should be formatted exactly as described in the CP Submission Instructions. It must unpack properly into its own properly named directly 

No Generated Files: 2 points - tar ball should not contain any .o or executable files. This keeps submitted file sizes small, and requires that submitted code compiles properly. This requirement does not apply to backup files generated automatically by your editor (e.g. README.md~ )... do not clear those out of your repository, since they exist in part to keep you from losing your work accidentally!)

Makefile: 2 points - program must build properly and completely, just by typing make in the top level repo directory.

Make clean: 2 points - we must be able to type make clean to correctly and completely clear out all generated files from your directory and sub-directories.

README.md: 2 points - your README.md file must include the information requested, including the honesty statement.

Empty Tar File: Submitting an empty tar (.tar.gz) file will result in a deduction of 25% of the total points for the corresponding coding project (e.g., if the project's total points are 40, the deduction will be 10 points). You can gain no advantage by submitting an empty file as a "placeholder" for your code! (yes, this happens, believe me... I've seen lots of tricks). It is your responsibility to make sure you do not submit an empty or corrupt tar file. You can check the size of the file and even download the submission from Brightspace and run it again for yourself in a brand new directory! 

Late Penalty Points

Every assignment has a "points per day late" associated with it. By default, this is 10%, meaning that you lose 10% of the total points for the assignment, for each day late. Submissions that arrive 1 minute late will be counted as 1 day late. Also, weekends count as a single day. So if an assignment is due Thursday at 11:59pm, then a submission that arrives on Friday is one day late, and a submission that arrives Saturday or Sunday will count as two days late. Monday is 3 days late, etc.

Sometimes, I will reduce the late penalty to 5% per day (or whatever else I decide), but I will never increase it beyond 10% per day.

You have several free late days (see the syllabus), which will be automatically applied if you have them, for each assignment. In other words, you may not "save" late days while still turning in the first assignment or two late. You can save them only by turning in your assignments on time.

Example

If an assignment is worth 30 points, and your submission earns 26 of those points, but you turn it in a day late and forget to properly implement make clean, but everything else about your submission is perfect, you will receive 26 - 3 (late) - 2 (make clean) = 21/30. 

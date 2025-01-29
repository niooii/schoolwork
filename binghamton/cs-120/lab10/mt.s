# Hewitt Wang lab10

	.text
main:
    # we will use $s0, $s1, $s2, $s3 for the loops
    # need to save these, and $ra too on the stack
    # in case we need to overwrite their current values
    addi $sp, $sp, -20
    sw $ra, 0($sp)
    sw $s0, 4($sp)
    sw $s1, 8($sp)
    sw $s2, 12($sp)
    sw $s3, 16($sp)

    # now the inner and outer loops
    # we will use $s1 to hold $a0 argument,
    # and $s3 to hold $a1 argument
    move $s1, $a0
    move $s3, $a1

    # outer loop - init
    li $s0, 1
oloop:
    bgt $s0, $s1, odone

    # inner loop - init
    li $s2, 1
iloop:
    bgt $s2, $s3, idone

    # multiply, print the number
    mul $t0, $s0, $s2
    move $a0, $t0
    li $v0, 1
    syscall

    # print a space
    # load space character from memory
    # to register in a single step
    lb $a0, space
    li $v0, 11
    syscall

    # increment the inner loop
    addi $s2, $s2, 1
    j iloop

idone:
    # print a new line
    lb $a0, lf
    li $v0, 11
    syscall

    # increment the outer loop
    addi $s0, $s0, 1
    j oloop

odone:
    # now restore the registers
    lw $s3, 16($sp)
    lw $s2, 12($sp)
    lw $s1, 8($sp)
    lw $s0, 4($sp)
    lw $ra, 0($sp)

    # move stack pointer back to where it was
    # before calling mt function
    addi $sp, $sp, 20
    jr $ra
	

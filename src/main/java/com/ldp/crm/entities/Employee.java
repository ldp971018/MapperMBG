package com.ldp.crm.entities;

import java.util.Date;
import javax.persistence.*;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastname;

    private String email;

    private Date birth;

    private Date createtime;

    @Column(name = "emp_image")
    private String empImage;

    @Column(name = "department_id")
    private Integer departmentId;

    public Employee(String lastname, String email, Date birth, Date createtime, String empImage, Integer departmentId) {
        this.lastname = lastname;
        this.email = email;
        this.birth = birth;
        this.createtime = createtime;
        this.empImage = empImage;
        this.departmentId = departmentId;
    }

    public Employee() {
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return emp_image
     */
    public String getEmpImage() {
        return empImage;
    }

    /**
     * @param empImage
     */
    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    /**
     * @return department_id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", createtime=" + createtime +
                ", empImage='" + empImage + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
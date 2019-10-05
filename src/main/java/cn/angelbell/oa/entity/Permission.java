package cn.angelbell.oa.entity;

import java.util.Date;

/**
 * Database Table Remarks:
 *   权限
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table admin_permission
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Permission {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.permission_id
     *
     * @mbggenerated
     */
    private Integer permissionId;

    /**
     * Database Column Remarks:
     *   所属上级
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.pid
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     * Database Column Remarks:
     *   名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   类型(1:目录,2:菜单,3:按钮)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.type
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     * Database Column Remarks:
     *   权限值
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.permission_value
     *
     * @mbggenerated
     */
    private String permissionValue;

    /**
     * Database Column Remarks:
     *   路径
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.uri
     *
     * @mbggenerated
     */
    private String uri;

    /**
     * Database Column Remarks:
     *   图标
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.icon
     *
     * @mbggenerated
     */
    private String icon;

    /**
     * Database Column Remarks:
     *   状态(0:禁止,1:正常)
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.ctime
     *
     * @mbggenerated
     */
    private Date ctime;

    /**
     * Database Column Remarks:
     *   排序
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_permission.orders
     *
     * @mbggenerated
     */
    private Long orders;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.permission_id
     *
     * @return the value of admin_permission.permission_id
     *
     * @mbggenerated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.permission_id
     *
     * @param permissionId the value for admin_permission.permission_id
     *
     * @mbggenerated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.pid
     *
     * @return the value of admin_permission.pid
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.pid
     *
     * @param pid the value for admin_permission.pid
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.name
     *
     * @return the value of admin_permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.name
     *
     * @param name the value for admin_permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.type
     *
     * @return the value of admin_permission.type
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.type
     *
     * @param type the value for admin_permission.type
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.permission_value
     *
     * @return the value of admin_permission.permission_value
     *
     * @mbggenerated
     */
    public String getPermissionValue() {
        return permissionValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.permission_value
     *
     * @param permissionValue the value for admin_permission.permission_value
     *
     * @mbggenerated
     */
    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue == null ? null : permissionValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.uri
     *
     * @return the value of admin_permission.uri
     *
     * @mbggenerated
     */
    public String getUri() {
        return uri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.uri
     *
     * @param uri the value for admin_permission.uri
     *
     * @mbggenerated
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.icon
     *
     * @return the value of admin_permission.icon
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.icon
     *
     * @param icon the value for admin_permission.icon
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.status
     *
     * @return the value of admin_permission.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.status
     *
     * @param status the value for admin_permission.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.ctime
     *
     * @return the value of admin_permission.ctime
     *
     * @mbggenerated
     */
    public Date getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.ctime
     *
     * @param ctime the value for admin_permission.ctime
     *
     * @mbggenerated
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_permission.orders
     *
     * @return the value of admin_permission.orders
     *
     * @mbggenerated
     */
    public Long getOrders() {
        return orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_permission.orders
     *
     * @param orders the value for admin_permission.orders
     *
     * @mbggenerated
     */
    public void setOrders(Long orders) {
        this.orders = orders;
    }
}
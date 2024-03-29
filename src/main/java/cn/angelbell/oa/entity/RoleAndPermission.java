package cn.angelbell.oa.entity;

/**
 * Database Table Remarks:
 *   角色权限关联表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table admin_role_permission
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class RoleAndPermission {
    /**
     * Database Column Remarks:
     *   编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_permission.role_permission_id
     *
     * @mbggenerated
     */
    private Integer rolePermissionId;

    /**
     * Database Column Remarks:
     *   角色编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_permission.role_id
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     * Database Column Remarks:
     *   权限编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column admin_role_permission.permission_id
     *
     * @mbggenerated
     */
    private Integer permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_permission.role_permission_id
     *
     * @return the value of admin_role_permission.role_permission_id
     *
     * @mbggenerated
     */
    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_permission.role_permission_id
     *
     * @param rolePermissionId the value for admin_role_permission.role_permission_id
     *
     * @mbggenerated
     */
    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_permission.role_id
     *
     * @return the value of admin_role_permission.role_id
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_permission.role_id
     *
     * @param roleId the value for admin_role_permission.role_id
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column admin_role_permission.permission_id
     *
     * @return the value of admin_role_permission.permission_id
     *
     * @mbggenerated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column admin_role_permission.permission_id
     *
     * @param permissionId the value for admin_role_permission.permission_id
     *
     * @mbggenerated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
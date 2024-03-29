package cn.angelbell.oa.entity;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table visitnet
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Visitnet {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   省份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.province
     *
     * @mbggenerated
     */
    private String province;

    /**
     * Database Column Remarks:
     *   城市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.city
     *
     * @mbggenerated
     */
    private String city;

    /**
     * Database Column Remarks:
     *   详细地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.addresses
     *
     * @mbggenerated
     */
    private String addresses;

    /**
     * Database Column Remarks:
     *   经纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.locationLat
     *
     * @mbggenerated
     */
    private String locationlat;

    /**
     * Database Column Remarks:
     *   ip地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.ip
     *
     * @mbggenerated
     */
    private String ip;

    /**
     * Database Column Remarks:
     *   端口
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.port
     *
     * @mbggenerated
     */
    private String port;

    /**
     * Database Column Remarks:
     *   浏览器信息
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.agent
     *
     * @mbggenerated
     */
    private String agent;

    /**
     * Database Column Remarks:
     *   时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitnet.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.id
     *
     * @return the value of visitnet.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.id
     *
     * @param id the value for visitnet.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.province
     *
     * @return the value of visitnet.province
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.province
     *
     * @param province the value for visitnet.province
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.city
     *
     * @return the value of visitnet.city
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.city
     *
     * @param city the value for visitnet.city
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.addresses
     *
     * @return the value of visitnet.addresses
     *
     * @mbggenerated
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.addresses
     *
     * @param addresses the value for visitnet.addresses
     *
     * @mbggenerated
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses == null ? null : addresses.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.locationLat
     *
     * @return the value of visitnet.locationLat
     *
     * @mbggenerated
     */
    public String getLocationlat() {
        return locationlat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.locationLat
     *
     * @param locationlat the value for visitnet.locationLat
     *
     * @mbggenerated
     */
    public void setLocationlat(String locationlat) {
        this.locationlat = locationlat == null ? null : locationlat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.ip
     *
     * @return the value of visitnet.ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.ip
     *
     * @param ip the value for visitnet.ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.port
     *
     * @return the value of visitnet.port
     *
     * @mbggenerated
     */
    public String getPort() {
        return port;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.port
     *
     * @param port the value for visitnet.port
     *
     * @mbggenerated
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.agent
     *
     * @return the value of visitnet.agent
     *
     * @mbggenerated
     */
    public String getAgent() {
        return agent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.agent
     *
     * @param agent the value for visitnet.agent
     *
     * @mbggenerated
     */
    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitnet.createTime
     *
     * @return the value of visitnet.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitnet.createTime
     *
     * @param createtime the value for visitnet.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
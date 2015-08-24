package com.ykh.dao.user.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ant_shake_tree on 15/8/24.
 */
@Table
@Entity
public class TempUser {
    <element name="tempConfID" type="u"/>
    <element name="userID" type="u"/>
    <element name="username" type="s"/>
    <element name="clientType" type="u"/>
    <element name="pinCode" type="u"/>
    <element name="domain" type="i"/>
    <element name="status" type="u"/>
    <element name="ip" type="au" size="4"/>
    <element name="role_type" type="au"/>
    <element name="time " type="t"/>

}

package com.techingen.twentyatmailhandlerservice.entity;
// Generated 16 Mar, 2011 8:49:46 PM by Hibernate Tools 3.2.1.GA



/**
 * FriendsMapping generated by hbm2java
 */
public class FriendsMapping  implements java.io.Serializable {


     private Integer friendsMappingId;
     private TwentyatUser twentyatUser;
     private TwentyatGroup twentyatGroup;

    public FriendsMapping() {
    }

    public FriendsMapping(TwentyatUser twentyatUser, TwentyatGroup twentyatGroup) {
       this.twentyatUser = twentyatUser;
       this.twentyatGroup = twentyatGroup;
    }
   
    public Integer getFriendsMappingId() {
        return this.friendsMappingId;
    }
    
    public void setFriendsMappingId(Integer friendsMappingId) {
        this.friendsMappingId = friendsMappingId;
    }
    public TwentyatUser getTwentyatUser() {
        return this.twentyatUser;
    }
    
    public void setTwentyatUser(TwentyatUser twentyatUser) {
        this.twentyatUser = twentyatUser;
    }
    public TwentyatGroup getTwentyatGroup() {
        return this.twentyatGroup;
    }
    
    public void setTwentyatGroup(TwentyatGroup twentyatGroup) {
        this.twentyatGroup = twentyatGroup;
    }




}



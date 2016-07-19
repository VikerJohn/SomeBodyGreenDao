package com.zwei.materialdesigndemo.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
public class Article {


    private int code;
    private String msg;


    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean last;
        private int totalPages;
        private int totalElements;
        private boolean first;
        private int numberOfElements;
        private int size;
        private int number;
        /**
         * id : 72
         * title : 123
         * content : <div>123</div>
         * thumbnail : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/articleImg/b532e651-4251-4c79-afa5-1f20984fb113.png
         * img : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/articleImg/78b69c46-165f-45d7-bdbe-1cc969c700c2.png
         * replyCount : 3
         * createTime : 2016-06-29 11:11:20
         * createUser : {"id":295,"username":"123","password":"123","salt":null,"nickname":"测试123","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/295/a1c1f8dd-b785-4ecc-829f-a4debf306d9e.jpg","gender":1,"grade":{"id":1,"name":"七年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":6,"name":"地理"},{"id":7,"name":"生物"}]},"mobilePhoneNumber":"123","mobilePhoneVerified":1,"school":{"id":"443231c7-1bbe-484b-98e4-a606497dd41d","name":"爱丁宝学校","type":2,"verified":0,"area":{"id":"1181700","name":"东莞市","shortName":"东莞","type":1},"createTime":null},"createTime":1453862356000,"lastLoginTime":1467946455000,"invitationCode":"47YJIK","invitationUser":{"id":323,"username":"qcx77513","password":"123456","salt":null,"nickname":"梁贝","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/323/90710524-7c38-4a3e-ae18-566feb99bebc.jpg","gender":1,"grade":{"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]},"mobilePhoneNumber":null,"mobilePhoneVerified":0,"school":{"id":"6ecbc93e-8d18-406d-aae9-1085176244b7","name":"鳌头中学","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null},"createTime":1457329123000,"lastLoginTime":1467886176000,"invitationCode":"YOKEZX","invitationUser":null,"allowNumber":0,"factNumber":0,"thirdPartyLogin":null},"allowNumber":10,"factNumber":10,"thirdPartyLogin":null}
         * collectionUser : [{"id":344,"username":"fgs25957","password":"123456","salt":null,"nickname":"莫言","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/344/29507f4c-dffe-4812-a6eb-3fe855c03bf8.jpg","gender":1,"grade":{"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]},"mobilePhoneNumber":null,"mobilePhoneVerified":0,"school":null,"createTime":1461901450000,"lastLoginTime":1467883521000,"invitationCode":"U238CB","invitationUser":{"id":346,"username":"bks76579","password":"123456","salt":null,"nickname":"","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/346/d525fd37-d1a5-46a5-b7b3-565e60af189c.jpg","gender":1,"grade":{"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]},"mobilePhoneNumber":null,"mobilePhoneVerified":0,"school":{"id":"887d3aea-5bfc-4497-8bb7-6a13eb984a83","name":"电力一局子校","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null},"createTime":1462344901000,"lastLoginTime":1463994867000,"invitationCode":"JUUR73","invitationUser":null,"allowNumber":2,"factNumber":2,"thirdPartyLogin":null},"allowNumber":1,"factNumber":0,"thirdPartyLogin":null}]
         * praiseUser : []
         * isNew : 1
         */

        private List<ContentBean> content;
        /**
         * direction : DESC
         * property : createTime
         * ignoreCase : false
         * nullHandling : NATIVE
         * ascending : false
         */

        private List<SortBean> sort;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public List<SortBean> getSort() {
            return sort;
        }

        public void setSort(List<SortBean> sort) {
            this.sort = sort;
        }

        public static class ContentBean {
            private int id;
            private String title;
            private String content;
            private String thumbnail;
            private String img;
            private int replyCount;
            private String createTime;
            /**
             * id : 295
             * username : 123
             * password : 123
             * salt : null
             * nickname : 测试123
             * userHead : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/295/a1c1f8dd-b785-4ecc-829f-a4debf306d9e.jpg
             * gender : 1
             * grade : {"id":1,"name":"七年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":6,"name":"地理"},{"id":7,"name":"生物"}]}
             * mobilePhoneNumber : 123
             * mobilePhoneVerified : 1
             * school : {"id":"443231c7-1bbe-484b-98e4-a606497dd41d","name":"爱丁宝学校","type":2,"verified":0,"area":{"id":"1181700","name":"东莞市","shortName":"东莞","type":1},"createTime":null}
             * createTime : 1453862356000
             * lastLoginTime : 1467946455000
             * invitationCode : 47YJIK
             * invitationUser : {"id":323,"username":"qcx77513","password":"123456","salt":null,"nickname":"梁贝","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/323/90710524-7c38-4a3e-ae18-566feb99bebc.jpg","gender":1,"grade":{"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]},"mobilePhoneNumber":null,"mobilePhoneVerified":0,"school":{"id":"6ecbc93e-8d18-406d-aae9-1085176244b7","name":"鳌头中学","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null},"createTime":1457329123000,"lastLoginTime":1467886176000,"invitationCode":"YOKEZX","invitationUser":null,"allowNumber":0,"factNumber":0,"thirdPartyLogin":null}
             * allowNumber : 10
             * factNumber : 10
             * thirdPartyLogin : null
             */

            private CreateUserBean createUser;
            private int isNew;
            /**
             * id : 344
             * username : fgs25957
             * password : 123456
             * salt : null
             * nickname : 莫言
             * userHead : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/344/29507f4c-dffe-4812-a6eb-3fe855c03bf8.jpg
             * gender : 1
             * grade : {"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]}
             * mobilePhoneNumber : null
             * mobilePhoneVerified : 0
             * school : null
             * createTime : 1461901450000
             * lastLoginTime : 1467883521000
             * invitationCode : U238CB
             * invitationUser : {"id":346,"username":"bks76579","password":"123456","salt":null,"nickname":"","userHead":"http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/346/d525fd37-d1a5-46a5-b7b3-565e60af189c.jpg","gender":1,"grade":{"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]},"mobilePhoneNumber":null,"mobilePhoneVerified":0,"school":{"id":"887d3aea-5bfc-4497-8bb7-6a13eb984a83","name":"电力一局子校","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null},"createTime":1462344901000,"lastLoginTime":1463994867000,"invitationCode":"JUUR73","invitationUser":null,"allowNumber":2,"factNumber":2,"thirdPartyLogin":null}
             * allowNumber : 1
             * factNumber : 0
             * thirdPartyLogin : null
             */

            private List<CollectionUserBean> collectionUser;
            private List<?> praiseUser;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public CreateUserBean getCreateUser() {
                return createUser;
            }

            public void setCreateUser(CreateUserBean createUser) {
                this.createUser = createUser;
            }

            public int getIsNew() {
                return isNew;
            }

            public void setIsNew(int isNew) {
                this.isNew = isNew;
            }

            public List<CollectionUserBean> getCollectionUser() {
                return collectionUser;
            }

            public void setCollectionUser(List<CollectionUserBean> collectionUser) {
                this.collectionUser = collectionUser;
            }

            public List<?> getPraiseUser() {
                return praiseUser;
            }

            public void setPraiseUser(List<?> praiseUser) {
                this.praiseUser = praiseUser;
            }

            public static class CreateUserBean {
                private int id;
                private String username;
                private String password;
                private Object salt;
                private String nickname;
                private String userHead;
                private int gender;
                /**
                 * id : 1
                 * name : 七年级
                 * section : 2
                 * sync : 1
                 * subjects : [{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":6,"name":"地理"},{"id":7,"name":"生物"}]
                 */

                private GradeBean grade;
                private String mobilePhoneNumber;
                private int mobilePhoneVerified;
                /**
                 * id : 443231c7-1bbe-484b-98e4-a606497dd41d
                 * name : 爱丁宝学校
                 * type : 2
                 * verified : 0
                 * area : {"id":"1181700","name":"东莞市","shortName":"东莞","type":1}
                 * createTime : null
                 */

                private SchoolBean school;
                private long createTime;
                private long lastLoginTime;
                private String invitationCode;
                /**
                 * id : 323
                 * username : qcx77513
                 * password : 123456
                 * salt : null
                 * nickname : 梁贝
                 * userHead : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/323/90710524-7c38-4a3e-ae18-566feb99bebc.jpg
                 * gender : 1
                 * grade : {"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]}
                 * mobilePhoneNumber : null
                 * mobilePhoneVerified : 0
                 * school : {"id":"6ecbc93e-8d18-406d-aae9-1085176244b7","name":"鳌头中学","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null}
                 * createTime : 1457329123000
                 * lastLoginTime : 1467886176000
                 * invitationCode : YOKEZX
                 * invitationUser : null
                 * allowNumber : 0
                 * factNumber : 0
                 * thirdPartyLogin : null
                 */

                private InvitationUserBean invitationUser;
                private int allowNumber;
                private int factNumber;
                private Object thirdPartyLogin;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public Object getSalt() {
                    return salt;
                }

                public void setSalt(Object salt) {
                    this.salt = salt;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getUserHead() {
                    return userHead;
                }

                public void setUserHead(String userHead) {
                    this.userHead = userHead;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public GradeBean getGrade() {
                    return grade;
                }

                public void setGrade(GradeBean grade) {
                    this.grade = grade;
                }

                public String getMobilePhoneNumber() {
                    return mobilePhoneNumber;
                }

                public void setMobilePhoneNumber(String mobilePhoneNumber) {
                    this.mobilePhoneNumber = mobilePhoneNumber;
                }

                public int getMobilePhoneVerified() {
                    return mobilePhoneVerified;
                }

                public void setMobilePhoneVerified(int mobilePhoneVerified) {
                    this.mobilePhoneVerified = mobilePhoneVerified;
                }

                public SchoolBean getSchool() {
                    return school;
                }

                public void setSchool(SchoolBean school) {
                    this.school = school;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public long getLastLoginTime() {
                    return lastLoginTime;
                }

                public void setLastLoginTime(long lastLoginTime) {
                    this.lastLoginTime = lastLoginTime;
                }

                public String getInvitationCode() {
                    return invitationCode;
                }

                public void setInvitationCode(String invitationCode) {
                    this.invitationCode = invitationCode;
                }

                public InvitationUserBean getInvitationUser() {
                    return invitationUser;
                }

                public void setInvitationUser(InvitationUserBean invitationUser) {
                    this.invitationUser = invitationUser;
                }

                public int getAllowNumber() {
                    return allowNumber;
                }

                public void setAllowNumber(int allowNumber) {
                    this.allowNumber = allowNumber;
                }

                public int getFactNumber() {
                    return factNumber;
                }

                public void setFactNumber(int factNumber) {
                    this.factNumber = factNumber;
                }

                public Object getThirdPartyLogin() {
                    return thirdPartyLogin;
                }

                public void setThirdPartyLogin(Object thirdPartyLogin) {
                    this.thirdPartyLogin = thirdPartyLogin;
                }

                public static class GradeBean {
                    private int id;
                    private String name;
                    private int section;
                    private int sync;
                    /**
                     * id : 1
                     * name : 数学
                     */

                    private List<SubjectsBean> subjects;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSection() {
                        return section;
                    }

                    public void setSection(int section) {
                        this.section = section;
                    }

                    public int getSync() {
                        return sync;
                    }

                    public void setSync(int sync) {
                        this.sync = sync;
                    }

                    public List<SubjectsBean> getSubjects() {
                        return subjects;
                    }

                    public void setSubjects(List<SubjectsBean> subjects) {
                        this.subjects = subjects;
                    }

                    public static class SubjectsBean {
                        private int id;
                        private String name;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }
                    }
                }

                public static class SchoolBean {
                    private String id;
                    private String name;
                    private int type;
                    private int verified;
                    /**
                     * id : 1181700
                     * name : 东莞市
                     * shortName : 东莞
                     * type : 1
                     */

                    private AreaBean area;
                    private Object createTime;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

                    public int getVerified() {
                        return verified;
                    }

                    public void setVerified(int verified) {
                        this.verified = verified;
                    }

                    public AreaBean getArea() {
                        return area;
                    }

                    public void setArea(AreaBean area) {
                        this.area = area;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public static class AreaBean {
                        private String id;
                        private String name;
                        private String shortName;
                        private int type;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getShortName() {
                            return shortName;
                        }

                        public void setShortName(String shortName) {
                            this.shortName = shortName;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }
                }

                public static class InvitationUserBean {
                    private int id;
                    private String username;
                    private String password;
                    private Object salt;
                    private String nickname;
                    private String userHead;
                    private int gender;
                    /**
                     * id : 3
                     * name : 九年级
                     * section : 2
                     * sync : 1
                     * subjects : [{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]
                     */

                    private GradeBean grade;
                    private Object mobilePhoneNumber;
                    private int mobilePhoneVerified;
                    /**
                     * id : 6ecbc93e-8d18-406d-aae9-1085176244b7
                     * name : 鳌头中学
                     * type : 2
                     * verified : 0
                     * area : {"id":"1180100","name":"广州市","shortName":"广州","type":1}
                     * createTime : null
                     */

                    private SchoolBean school;
                    private long createTime;
                    private long lastLoginTime;
                    private String invitationCode;
                    private Object invitationUser;
                    private int allowNumber;
                    private int factNumber;
                    private Object thirdPartyLogin;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getUsername() {
                        return username;
                    }

                    public void setUsername(String username) {
                        this.username = username;
                    }

                    public String getPassword() {
                        return password;
                    }

                    public void setPassword(String password) {
                        this.password = password;
                    }

                    public Object getSalt() {
                        return salt;
                    }

                    public void setSalt(Object salt) {
                        this.salt = salt;
                    }

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public String getUserHead() {
                        return userHead;
                    }

                    public void setUserHead(String userHead) {
                        this.userHead = userHead;
                    }

                    public int getGender() {
                        return gender;
                    }

                    public void setGender(int gender) {
                        this.gender = gender;
                    }

                    public GradeBean getGrade() {
                        return grade;
                    }

                    public void setGrade(GradeBean grade) {
                        this.grade = grade;
                    }

                    public Object getMobilePhoneNumber() {
                        return mobilePhoneNumber;
                    }

                    public void setMobilePhoneNumber(Object mobilePhoneNumber) {
                        this.mobilePhoneNumber = mobilePhoneNumber;
                    }

                    public int getMobilePhoneVerified() {
                        return mobilePhoneVerified;
                    }

                    public void setMobilePhoneVerified(int mobilePhoneVerified) {
                        this.mobilePhoneVerified = mobilePhoneVerified;
                    }

                    public SchoolBean getSchool() {
                        return school;
                    }

                    public void setSchool(SchoolBean school) {
                        this.school = school;
                    }

                    public long getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(long createTime) {
                        this.createTime = createTime;
                    }

                    public long getLastLoginTime() {
                        return lastLoginTime;
                    }

                    public void setLastLoginTime(long lastLoginTime) {
                        this.lastLoginTime = lastLoginTime;
                    }

                    public String getInvitationCode() {
                        return invitationCode;
                    }

                    public void setInvitationCode(String invitationCode) {
                        this.invitationCode = invitationCode;
                    }

                    public Object getInvitationUser() {
                        return invitationUser;
                    }

                    public void setInvitationUser(Object invitationUser) {
                        this.invitationUser = invitationUser;
                    }

                    public int getAllowNumber() {
                        return allowNumber;
                    }

                    public void setAllowNumber(int allowNumber) {
                        this.allowNumber = allowNumber;
                    }

                    public int getFactNumber() {
                        return factNumber;
                    }

                    public void setFactNumber(int factNumber) {
                        this.factNumber = factNumber;
                    }

                    public Object getThirdPartyLogin() {
                        return thirdPartyLogin;
                    }

                    public void setThirdPartyLogin(Object thirdPartyLogin) {
                        this.thirdPartyLogin = thirdPartyLogin;
                    }

                    public static class GradeBean {
                        private int id;
                        private String name;
                        private int section;
                        private int sync;
                        /**
                         * id : 1
                         * name : 数学
                         */

                        private List<SubjectsBean> subjects;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getSection() {
                            return section;
                        }

                        public void setSection(int section) {
                            this.section = section;
                        }

                        public int getSync() {
                            return sync;
                        }

                        public void setSync(int sync) {
                            this.sync = sync;
                        }

                        public List<SubjectsBean> getSubjects() {
                            return subjects;
                        }

                        public void setSubjects(List<SubjectsBean> subjects) {
                            this.subjects = subjects;
                        }

                        public static class SubjectsBean {
                            private int id;
                            private String name;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class SchoolBean {
                        private String id;
                        private String name;
                        private int type;
                        private int verified;
                        /**
                         * id : 1180100
                         * name : 广州市
                         * shortName : 广州
                         * type : 1
                         */

                        private AreaBean area;
                        private Object createTime;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }

                        public int getVerified() {
                            return verified;
                        }

                        public void setVerified(int verified) {
                            this.verified = verified;
                        }

                        public AreaBean getArea() {
                            return area;
                        }

                        public void setArea(AreaBean area) {
                            this.area = area;
                        }

                        public Object getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(Object createTime) {
                            this.createTime = createTime;
                        }

                        public static class AreaBean {
                            private String id;
                            private String name;
                            private String shortName;
                            private int type;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getShortName() {
                                return shortName;
                            }

                            public void setShortName(String shortName) {
                                this.shortName = shortName;
                            }

                            public int getType() {
                                return type;
                            }

                            public void setType(int type) {
                                this.type = type;
                            }
                        }
                    }
                }
            }

            public static class CollectionUserBean {
                private int id;
                private String username;
                private String password;
                private Object salt;
                private String nickname;
                private String userHead;
                private int gender;
                /**
                 * id : 3
                 * name : 九年级
                 * section : 2
                 * sync : 1
                 * subjects : [{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]
                 */

                private GradeBean grade;
                private Object mobilePhoneNumber;
                private int mobilePhoneVerified;
                private Object school;
                private long createTime;
                private long lastLoginTime;
                private String invitationCode;
                /**
                 * id : 346
                 * username : bks76579
                 * password : 123456
                 * salt : null
                 * nickname :
                 * userHead : http://xuebangsoft-questions.oss-cn-shenzhen.aliyuncs.com/userdata/346/d525fd37-d1a5-46a5-b7b3-565e60af189c.jpg
                 * gender : 1
                 * grade : {"id":3,"name":"九年级","section":2,"sync":1,"subjects":[{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]}
                 * mobilePhoneNumber : null
                 * mobilePhoneVerified : 0
                 * school : {"id":"887d3aea-5bfc-4497-8bb7-6a13eb984a83","name":"电力一局子校","type":2,"verified":0,"area":{"id":"1180100","name":"广州市","shortName":"广州","type":1},"createTime":null}
                 * createTime : 1462344901000
                 * lastLoginTime : 1463994867000
                 * invitationCode : JUUR73
                 * invitationUser : null
                 * allowNumber : 2
                 * factNumber : 2
                 * thirdPartyLogin : null
                 */

                private InvitationUserBean invitationUser;
                private int allowNumber;
                private int factNumber;
                private Object thirdPartyLogin;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public Object getSalt() {
                    return salt;
                }

                public void setSalt(Object salt) {
                    this.salt = salt;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getUserHead() {
                    return userHead;
                }

                public void setUserHead(String userHead) {
                    this.userHead = userHead;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public GradeBean getGrade() {
                    return grade;
                }

                public void setGrade(GradeBean grade) {
                    this.grade = grade;
                }

                public Object getMobilePhoneNumber() {
                    return mobilePhoneNumber;
                }

                public void setMobilePhoneNumber(Object mobilePhoneNumber) {
                    this.mobilePhoneNumber = mobilePhoneNumber;
                }

                public int getMobilePhoneVerified() {
                    return mobilePhoneVerified;
                }

                public void setMobilePhoneVerified(int mobilePhoneVerified) {
                    this.mobilePhoneVerified = mobilePhoneVerified;
                }

                public Object getSchool() {
                    return school;
                }

                public void setSchool(Object school) {
                    this.school = school;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public long getLastLoginTime() {
                    return lastLoginTime;
                }

                public void setLastLoginTime(long lastLoginTime) {
                    this.lastLoginTime = lastLoginTime;
                }

                public String getInvitationCode() {
                    return invitationCode;
                }

                public void setInvitationCode(String invitationCode) {
                    this.invitationCode = invitationCode;
                }

                public InvitationUserBean getInvitationUser() {
                    return invitationUser;
                }

                public void setInvitationUser(InvitationUserBean invitationUser) {
                    this.invitationUser = invitationUser;
                }

                public int getAllowNumber() {
                    return allowNumber;
                }

                public void setAllowNumber(int allowNumber) {
                    this.allowNumber = allowNumber;
                }

                public int getFactNumber() {
                    return factNumber;
                }

                public void setFactNumber(int factNumber) {
                    this.factNumber = factNumber;
                }

                public Object getThirdPartyLogin() {
                    return thirdPartyLogin;
                }

                public void setThirdPartyLogin(Object thirdPartyLogin) {
                    this.thirdPartyLogin = thirdPartyLogin;
                }

                public static class GradeBean {
                    private int id;
                    private String name;
                    private int section;
                    private int sync;
                    /**
                     * id : 1
                     * name : 数学
                     */

                    private List<SubjectsBean> subjects;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getSection() {
                        return section;
                    }

                    public void setSection(int section) {
                        this.section = section;
                    }

                    public int getSync() {
                        return sync;
                    }

                    public void setSync(int sync) {
                        this.sync = sync;
                    }

                    public List<SubjectsBean> getSubjects() {
                        return subjects;
                    }

                    public void setSubjects(List<SubjectsBean> subjects) {
                        this.subjects = subjects;
                    }

                    public static class SubjectsBean {
                        private int id;
                        private String name;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }
                    }
                }

                public static class InvitationUserBean {
                    private int id;
                    private String username;
                    private String password;
                    private Object salt;
                    private String nickname;
                    private String userHead;
                    private int gender;
                    /**
                     * id : 3
                     * name : 九年级
                     * section : 2
                     * sync : 1
                     * subjects : [{"id":1,"name":"数学"},{"id":2,"name":"英语"},{"id":3,"name":"语文"},{"id":4,"name":"政治"},{"id":5,"name":"历史"},{"id":8,"name":"物理"},{"id":9,"name":"化学"}]
                     */

                    private GradeBean grade;
                    private Object mobilePhoneNumber;
                    private int mobilePhoneVerified;
                    /**
                     * id : 887d3aea-5bfc-4497-8bb7-6a13eb984a83
                     * name : 电力一局子校
                     * type : 2
                     * verified : 0
                     * area : {"id":"1180100","name":"广州市","shortName":"广州","type":1}
                     * createTime : null
                     */

                    private SchoolBean school;
                    private long createTime;
                    private long lastLoginTime;
                    private String invitationCode;
                    private Object invitationUser;
                    private int allowNumber;
                    private int factNumber;
                    private Object thirdPartyLogin;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getUsername() {
                        return username;
                    }

                    public void setUsername(String username) {
                        this.username = username;
                    }

                    public String getPassword() {
                        return password;
                    }

                    public void setPassword(String password) {
                        this.password = password;
                    }

                    public Object getSalt() {
                        return salt;
                    }

                    public void setSalt(Object salt) {
                        this.salt = salt;
                    }

                    public String getNickname() {
                        return nickname;
                    }

                    public void setNickname(String nickname) {
                        this.nickname = nickname;
                    }

                    public String getUserHead() {
                        return userHead;
                    }

                    public void setUserHead(String userHead) {
                        this.userHead = userHead;
                    }

                    public int getGender() {
                        return gender;
                    }

                    public void setGender(int gender) {
                        this.gender = gender;
                    }

                    public GradeBean getGrade() {
                        return grade;
                    }

                    public void setGrade(GradeBean grade) {
                        this.grade = grade;
                    }

                    public Object getMobilePhoneNumber() {
                        return mobilePhoneNumber;
                    }

                    public void setMobilePhoneNumber(Object mobilePhoneNumber) {
                        this.mobilePhoneNumber = mobilePhoneNumber;
                    }

                    public int getMobilePhoneVerified() {
                        return mobilePhoneVerified;
                    }

                    public void setMobilePhoneVerified(int mobilePhoneVerified) {
                        this.mobilePhoneVerified = mobilePhoneVerified;
                    }

                    public SchoolBean getSchool() {
                        return school;
                    }

                    public void setSchool(SchoolBean school) {
                        this.school = school;
                    }

                    public long getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(long createTime) {
                        this.createTime = createTime;
                    }

                    public long getLastLoginTime() {
                        return lastLoginTime;
                    }

                    public void setLastLoginTime(long lastLoginTime) {
                        this.lastLoginTime = lastLoginTime;
                    }

                    public String getInvitationCode() {
                        return invitationCode;
                    }

                    public void setInvitationCode(String invitationCode) {
                        this.invitationCode = invitationCode;
                    }

                    public Object getInvitationUser() {
                        return invitationUser;
                    }

                    public void setInvitationUser(Object invitationUser) {
                        this.invitationUser = invitationUser;
                    }

                    public int getAllowNumber() {
                        return allowNumber;
                    }

                    public void setAllowNumber(int allowNumber) {
                        this.allowNumber = allowNumber;
                    }

                    public int getFactNumber() {
                        return factNumber;
                    }

                    public void setFactNumber(int factNumber) {
                        this.factNumber = factNumber;
                    }

                    public Object getThirdPartyLogin() {
                        return thirdPartyLogin;
                    }

                    public void setThirdPartyLogin(Object thirdPartyLogin) {
                        this.thirdPartyLogin = thirdPartyLogin;
                    }

                    public static class GradeBean {
                        private int id;
                        private String name;
                        private int section;
                        private int sync;
                        /**
                         * id : 1
                         * name : 数学
                         */

                        private List<SubjectsBean> subjects;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getSection() {
                            return section;
                        }

                        public void setSection(int section) {
                            this.section = section;
                        }

                        public int getSync() {
                            return sync;
                        }

                        public void setSync(int sync) {
                            this.sync = sync;
                        }

                        public List<SubjectsBean> getSubjects() {
                            return subjects;
                        }

                        public void setSubjects(List<SubjectsBean> subjects) {
                            this.subjects = subjects;
                        }

                        public static class SubjectsBean {
                            private int id;
                            private String name;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }
                        }
                    }

                    public static class SchoolBean {
                        private String id;
                        private String name;
                        private int type;
                        private int verified;
                        /**
                         * id : 1180100
                         * name : 广州市
                         * shortName : 广州
                         * type : 1
                         */

                        private AreaBean area;
                        private Object createTime;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }

                        public int getVerified() {
                            return verified;
                        }

                        public void setVerified(int verified) {
                            this.verified = verified;
                        }

                        public AreaBean getArea() {
                            return area;
                        }

                        public void setArea(AreaBean area) {
                            this.area = area;
                        }

                        public Object getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(Object createTime) {
                            this.createTime = createTime;
                        }

                        public static class AreaBean {
                            private String id;
                            private String name;
                            private String shortName;
                            private int type;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getShortName() {
                                return shortName;
                            }

                            public void setShortName(String shortName) {
                                this.shortName = shortName;
                            }

                            public int getType() {
                                return type;
                            }

                            public void setType(int type) {
                                this.type = type;
                            }
                        }
                    }
                }
            }
        }

        public static class SortBean {
            private String direction;
            private String property;
            private boolean ignoreCase;
            private String nullHandling;
            private boolean ascending;

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public boolean isIgnoreCase() {
                return ignoreCase;
            }

            public void setIgnoreCase(boolean ignoreCase) {
                this.ignoreCase = ignoreCase;
            }

            public String getNullHandling() {
                return nullHandling;
            }

            public void setNullHandling(String nullHandling) {
                this.nullHandling = nullHandling;
            }

            public boolean isAscending() {
                return ascending;
            }

            public void setAscending(boolean ascending) {
                this.ascending = ascending;
            }
        }
    }
}

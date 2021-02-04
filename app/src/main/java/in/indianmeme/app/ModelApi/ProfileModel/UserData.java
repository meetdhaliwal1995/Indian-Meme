package in.indianmeme.app.ModelApi.ProfileModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ip_address")
    @Expose
    private String ipAddress;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("email_code")
    @Expose
    private String emailCode;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("cover")
    @Expose
    private String cover;
    @SerializedName("country_id")
    @Expose
    private Integer countryId;
    @SerializedName("about")
    @Expose
    private Object about;
    @SerializedName("google")
    @Expose
    private String google;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("admin")
    @Expose
    private Integer admin;
    @SerializedName("verified")
    @Expose
    private Integer verified;
    @SerializedName("last_seen")
    @Expose
    private String lastSeen;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("is_pro")
    @Expose
    private Integer isPro;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("p_privacy")
    @Expose
    private String pPrivacy;
    @SerializedName("c_privacy")
    @Expose
    private String cPrivacy;
    @SerializedName("n_on_like")
    @Expose
    private String nOnLike;
    @SerializedName("n_on_mention")
    @Expose
    private String nOnMention;
    @SerializedName("n_on_comment")
    @Expose
    private String nOnComment;
    @SerializedName("n_on_follow")
    @Expose
    private String nOnFollow;
    @SerializedName("n_on_comment_like")
    @Expose
    private String nOnCommentLike;
    @SerializedName("n_on_comment_reply")
    @Expose
    private String nOnCommentReply;
    @SerializedName("startup_avatar")
    @Expose
    private Integer startupAvatar;
    @SerializedName("startup_info")
    @Expose
    private Integer startupInfo;
    @SerializedName("startup_follow")
    @Expose
    private Integer startupFollow;
    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("search_engines")
    @Expose
    private String searchEngines;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("device_id")
    @Expose
    private String deviceId;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("wallet")
    @Expose
    private String wallet;
    @SerializedName("referrer")
    @Expose
    private Integer referrer;
    @SerializedName("profile")
    @Expose
    private Integer profile;
    @SerializedName("business_account")
    @Expose
    private Integer businessAccount;
    @SerializedName("paypal_email")
    @Expose
    private String paypalEmail;
    @SerializedName("b_name")
    @Expose
    private String bName;
    @SerializedName("b_email")
    @Expose
    private String bEmail;
    @SerializedName("b_phone")
    @Expose
    private String bPhone;
    @SerializedName("b_site")
    @Expose
    private String bSite;
    @SerializedName("b_site_action")
    @Expose
    private String bSiteAction;
    @SerializedName("uploads")
    @Expose
    private Integer uploads;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("uname")
    @Expose
    private String uname;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("following")
    @Expose
    private Integer following;
    @SerializedName("favourites")
    @Expose
    private Integer favourites;
    @SerializedName("posts_count")
    @Expose
    private Integer postsCount;
    @SerializedName("time_text")
    @Expose
    private String timeText;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Object getAbout() {
        return about;
    }

    public void setAbout(Object about) {
        this.about = about;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public Integer getIsPro() {
        return isPro;
    }

    public void setIsPro(Integer isPro) {
        this.isPro = isPro;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    public String getPPrivacy() {
        return pPrivacy;
    }

    public void setPPrivacy(String pPrivacy) {
        this.pPrivacy = pPrivacy;
    }

    public String getCPrivacy() {
        return cPrivacy;
    }

    public void setCPrivacy(String cPrivacy) {
        this.cPrivacy = cPrivacy;
    }

    public String getNOnLike() {
        return nOnLike;
    }

    public void setNOnLike(String nOnLike) {
        this.nOnLike = nOnLike;
    }

    public String getNOnMention() {
        return nOnMention;
    }

    public void setNOnMention(String nOnMention) {
        this.nOnMention = nOnMention;
    }

    public String getNOnComment() {
        return nOnComment;
    }

    public void setNOnComment(String nOnComment) {
        this.nOnComment = nOnComment;
    }

    public String getNOnFollow() {
        return nOnFollow;
    }

    public void setNOnFollow(String nOnFollow) {
        this.nOnFollow = nOnFollow;
    }

    public String getNOnCommentLike() {
        return nOnCommentLike;
    }

    public void setNOnCommentLike(String nOnCommentLike) {
        this.nOnCommentLike = nOnCommentLike;
    }

    public String getNOnCommentReply() {
        return nOnCommentReply;
    }

    public void setNOnCommentReply(String nOnCommentReply) {
        this.nOnCommentReply = nOnCommentReply;
    }

    public Integer getStartupAvatar() {
        return startupAvatar;
    }

    public void setStartupAvatar(Integer startupAvatar) {
        this.startupAvatar = startupAvatar;
    }

    public Integer getStartupInfo() {
        return startupInfo;
    }

    public void setStartupInfo(Integer startupInfo) {
        this.startupInfo = startupInfo;
    }

    public Integer getStartupFollow() {
        return startupFollow;
    }

    public void setStartupFollow(Integer startupFollow) {
        this.startupFollow = startupFollow;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSearchEngines() {
        return searchEngines;
    }

    public void setSearchEngines(String searchEngines) {
        this.searchEngines = searchEngines;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public Integer getReferrer() {
        return referrer;
    }

    public void setReferrer(Integer referrer) {
        this.referrer = referrer;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getBusinessAccount() {
        return businessAccount;
    }

    public void setBusinessAccount(Integer businessAccount) {
        this.businessAccount = businessAccount;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getBEmail() {
        return bEmail;
    }

    public void setBEmail(String bEmail) {
        this.bEmail = bEmail;
    }

    public String getBPhone() {
        return bPhone;
    }

    public void setBPhone(String bPhone) {
        this.bPhone = bPhone;
    }

    public String getBSite() {
        return bSite;
    }

    public void setBSite(String bSite) {
        this.bSite = bSite;
    }

    public String getBSiteAction() {
        return bSiteAction;
    }

    public void setBSiteAction(String bSiteAction) {
        this.bSiteAction = bSiteAction;
    }

    public Integer getUploads() {
        return uploads;
    }

    public void setUploads(Integer uploads) {
        this.uploads = uploads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Integer getFavourites() {
        return favourites;
    }

    public void setFavourites(Integer favourites) {
        this.favourites = favourites;
    }

    public Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

    public String getTimeText() {
        return timeText;
    }

    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

}

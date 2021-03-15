package in.indianmeme.app.ModelApi.SendMessage;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("deleted_fs2")
	private String deletedFs2;

	@SerializedName("deleted_fs1")
	private String deletedFs1;

	@SerializedName("from_id")
	private int fromId;

	@SerializedName("to_id")
	private int toId;

	@SerializedName("media_file")
	private String mediaFile;

	@SerializedName("seen")
	private String seen;

	@SerializedName("time_text")
	private String timeText;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("extra")
	private String extra;

	@SerializedName("id")
	private int id;

	@SerializedName("text")
	private String text;

	@SerializedName("media_name")
	private String mediaName;

	@SerializedName("time")
	private String time;

	@SerializedName("hash_id")
	private String hashId;

	public void setDeletedFs2(String deletedFs2){
		this.deletedFs2 = deletedFs2;
	}

	public String getDeletedFs2(){
		return deletedFs2;
	}

	public void setDeletedFs1(String deletedFs1){
		this.deletedFs1 = deletedFs1;
	}

	public String getDeletedFs1(){
		return deletedFs1;
	}

	public void setFromId(int fromId){
		this.fromId = fromId;
	}

	public int getFromId(){
		return fromId;
	}

	public void setToId(int toId){
		this.toId = toId;
	}

	public int getToId(){
		return toId;
	}

	public void setMediaFile(String mediaFile){
		this.mediaFile = mediaFile;
	}

	public String getMediaFile(){
		return mediaFile;
	}

	public void setSeen(String seen){
		this.seen = seen;
	}

	public String getSeen(){
		return seen;
	}

	public void setTimeText(String timeText){
		this.timeText = timeText;
	}

	public String getTimeText(){
		return timeText;
	}

	public void setMediaType(String mediaType){
		this.mediaType = mediaType;
	}

	public String getMediaType(){
		return mediaType;
	}

	public void setExtra(String extra){
		this.extra = extra;
	}

	public String getExtra(){
		return extra;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setMediaName(String mediaName){
		this.mediaName = mediaName;
	}

	public String getMediaName(){
		return mediaName;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setHashId(String hashId){
		this.hashId = hashId;
	}

	public String getHashId(){
		return hashId;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"deleted_fs2 = '" + deletedFs2 + '\'' + 
			",deleted_fs1 = '" + deletedFs1 + '\'' + 
			",from_id = '" + fromId + '\'' + 
			",to_id = '" + toId + '\'' + 
			",media_file = '" + mediaFile + '\'' + 
			",seen = '" + seen + '\'' + 
			",time_text = '" + timeText + '\'' + 
			",media_type = '" + mediaType + '\'' + 
			",extra = '" + extra + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			",media_name = '" + mediaName + '\'' + 
			",time = '" + time + '\'' + 
			",hash_id = '" + hashId + '\'' + 
			"}";
		}
}
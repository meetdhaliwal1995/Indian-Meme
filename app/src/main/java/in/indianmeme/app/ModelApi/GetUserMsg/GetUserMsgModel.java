package in.indianmeme.app.ModelApi.GetUserMsg;

import com.google.gson.annotations.SerializedName;

public class GetUserMsgModel{

	@SerializedName("code")
	private String code;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private String status;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"GetUserMsgModel{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
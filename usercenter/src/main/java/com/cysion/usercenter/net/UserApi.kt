package com.cysion.usercenter.net

import com.cysion.ktbox.net.BaseCaller
import com.cysion.ktbox.net.BaseResponse
import com.cysion.usercenter.entity.Blog
import com.cysion.usercenter.entity.Carousel
import com.cysion.usercenter.entity.UserEntity
import io.reactivex.Observable
import retrofit2.http.*

object UserCaller : BaseCaller<UserApi>(UserUrls.HOST, UserApi::class.java, false)
interface UserApi {

    @GET("toploopers")
    fun getgetCarousel(): Observable<BaseResponse<MutableList<Carousel>>>

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password2") password2: String
    ): Observable<BaseResponse<UserEntity>>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<BaseResponse<UserEntity>>

    @FormUrlEncoded
    @POST("updateuser")
    fun updateUserInfo(
        @Field("nickname") nickname: String,
        @Field("desc") desc: String,
        @Field("avatar") avatar: String = ""
    ): Observable<BaseResponse<UserEntity>>

    @POST("userdetail")
    fun getUserInfo(): Observable<BaseResponse<UserEntity>>

//    以下，博客相关

    @GET("blog/list")
    fun getBlogList(@Query("page") page: Int = 1): Observable<BaseResponse<MutableList<Blog>>>


    @GET("blog/userlist")
    fun getUserBlogList(@Query("page") page: Int): Observable<BaseResponse<MutableList<Blog>>>

    @FormUrlEncoded
    @POST("blog/del")
    fun delBlog(@Field("blogId") blogId: String): Observable<BaseResponse<Any?>>


    @FormUrlEncoded
    @POST("blog/add")
    fun createBlog(@Field("title") title: String, @Field("text") text: String): Observable<BaseResponse<Any?>>


}
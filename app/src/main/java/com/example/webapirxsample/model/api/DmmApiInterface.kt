package com.example.webapirxsample.model.api

import com.example.webapirxsample.common.Constants
import com.example.webapirxsample.model.DmmApiResult
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface DmmApiInterface {

    //http://zipcloud.ibsnet.co.jp/api/search?zipcode=1000001のドメイン名以下の部分を記述する
    //FQDNは別のところで指定する
    @GET(Constants.search_url)
    fun listItems(): Observable<DmmApiResult>
    //@Queryが?zipcode=ZipCideを生成してくれる ZipCodeは関数の引数として与えられる
    //返値としてWebAPIを叩きにいくサービスが生成される
    //ジェネリクスには返値としてさきほど作成したデータの型を指定しておく
    //fun apiDemo(@Query("keyword") keyword:String): Observable<ZipApiData>

    @GET(Constants.keyword_search_url)
    fun keywordSearch(@Query("keyword") keyword:String): Observable<DmmApiResult>
}
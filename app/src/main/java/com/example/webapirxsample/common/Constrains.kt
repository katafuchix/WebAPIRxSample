package com.example.webapirxsample.common

object Constants {
    // APIID
    //static let api_id           = " YOUR DMM API ID "
    // アフィリエイトID
    //static let affiliate_id     = " YOUR DMM AFFILIATE ID "

    // APIID
    const val api_id           = "Bu045c0gVX51t1zMwn22"
    // アフィリエイトID
    const val affiliate_id     = "modemode-990"
    // 1ページに表示する件数
    const val hits             = 20
    // 出力形式
    const val output           = "json"

    const val search_url = "affiliate/v3/ItemList?output=${output}&site=DMM.com&offset=21&service=digital&hits=10&keyword=佐藤&page=2&floor=idol&sort=date&api_id=Bu045c0gVX51t1zMwn22&affiliate_id=modemode-990"

    const val keyword_search_url = "affiliate/v3/ItemList?output=${output}&site=DMM.com&service=digital&hits=${hits}&page=1&floor=idol&sort=date&api_id=${api_id}&affiliate_id=${affiliate_id}"

    const val actress_search_url = "affiliate/v3/ActressSearch?output=${output}&api_id=${api_id}&page=1&sort=name&hits=${hits}&affiliate_id=${affiliate_id}"
}
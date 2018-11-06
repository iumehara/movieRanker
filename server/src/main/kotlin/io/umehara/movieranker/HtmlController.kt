package io.umehara.movieranker

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HtmlController {
    @RequestMapping("/")
    fun home(): String {
        return "index"
    }
}
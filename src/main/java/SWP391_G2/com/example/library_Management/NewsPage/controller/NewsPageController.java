package SWP391_G2.com.example.library_Management.NewsPage.controller;

import SWP391_G2.com.example.library_Management.Entity.Author;
import SWP391_G2.com.example.library_Management.Entity.Book;
import SWP391_G2.com.example.library_Management.Entity.Category;
import SWP391_G2.com.example.library_Management.Entity.News;
import SWP391_G2.com.example.library_Management.NewsPage.service.NewsPageService;
import SWP391_G2.com.example.library_Management.Staff.ContentWriter.service.ContentWriterNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/newsPage")
public class NewsPageController {
    @Autowired
    private NewsPageService newsPageService;

    @GetMapping("/list")
    public String listNews(Model theModel, @Param("title") String title, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Page<News> newsPage;

        if(title != null) {
            newsPage = newsPageService.findNewsByTitle(title, page, size);
            theModel.addAttribute("searchtitle", title);
        } else {
            newsPage = newsPageService.getAllNews(page, size);
        }

        // Get top 3 news
        List<News> top3News = newsPageService.getTop3News();

        theModel.addAttribute("newsPage", newsPage);
        theModel.addAttribute("currentPage", page);
        theModel.addAttribute("totalPages", newsPage.getTotalPages());
        theModel.addAttribute("top3News", top3News);

        return "Customer/News/NewsPage";
    }

    @GetMapping("/newDetail")
    public String showNewDetail(@RequestParam("newId") int theId, Model theModel) {
        News newsItem = newsPageService.getNewsById(theId);

        // Get top 3 news
        List<News> top3News = newsPageService.getTop3News();

        theModel.addAttribute("newsItem", newsItem);
        theModel.addAttribute("top3News", top3News);
        return "Customer/News/NewDetail";
    }
}

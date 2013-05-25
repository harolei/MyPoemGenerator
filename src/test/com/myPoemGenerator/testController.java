package com.myPoemGenerator;

import com.myPoemGenerator.controller.PageOneController;
import com.myPoemGenerator.controller.WeatherSearchController;
import com.myPoemGenerator.model.PoemSentence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/myPoemGenerator-servlet.xml"})
public class testController {
    @Autowired
    private PageOneController pageOneController;


    private MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        this.request = new MockHttpServletRequest("POST", "/MyPoemGenerator/page1");
    }
    @Test
    public void shouldReturnPage1WhenValidateFail() throws Exception {
        pageOneController = new PageOneController();
        request.setParameter("sentence","");
        ModelMap model = mock(ModelMap.class);
        PoemSentence sentence = new PoemSentence();
        sentence.setSentence(null);
        BindingResult result = mock(BindingResult.class);
        SessionStatus status = mock(SessionStatus.class);
        given(result.hasErrors()).willReturn(true);

        assertThat(pageOneController.handlePost(model, sentence, result, status, request), is("page1"));

    }

    @Test
    public void shouldReturnSearchWeather() throws Exception {
        WeatherSearchController controller = new WeatherSearchController();
        ModelMap model = mock(ModelMap.class);

    }
}

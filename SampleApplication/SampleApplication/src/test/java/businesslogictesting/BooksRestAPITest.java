package businesslogictesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.javasample.SpringBootSampleApplication;
import com.javasample.model.Books;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootSampleApplication.class)
public class BooksRestAPITest {
    @Autowired
    MockMvc mockMvc;

  

    @Test
    void BookPriceLessThanZeroIsInvalid() {
        Books Test= new Books();
        Test.setPrice(-1);
        assertEquals(false,Test.IsPriceValid());
    }
    @Test
    void BookPriceGreaterThanZeroIsvalid() {
        Books Test= new Books();
        Test.setPrice(10);
        assertEquals(true,Test.IsPriceValid());
    }

    @Test
    void BookPriceIsZeroIsValid() {
        Books Test= new Books();
        Test.setPrice(0);
        assertEquals(true,Test.IsPriceValid());
    }

    @Test
    void BookPriceIsvalid() {
        Books Test= new Books();
        Test.setPrice(20000);
        assertEquals(true,Test.IsPriceValid());
    }

    @Test
    void IsBookNamevalid() {
        Books Test= new Books();
        Test.setBookname(" ");
        assertEquals(true,Test.IsBookNameValid());
    }

    @Test
    void Isauthorvalid() {
        Books Test= new Books();
        Test.setAuthor(" ");
        assertEquals(true,Test.Isauthorvalid());
    }
}

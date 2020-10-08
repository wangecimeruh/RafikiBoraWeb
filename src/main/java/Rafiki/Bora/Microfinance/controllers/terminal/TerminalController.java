package Rafiki.Bora.Microfinance.controllers.terminal;

import Rafiki.Bora.Microfinance.dto.TerminalDto;
import Rafiki.Bora.Microfinance.model.terminal.Terminal;
import Rafiki.Bora.Microfinance.service.terminalService.TerminalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/terminals")
public class TerminalController {

        @Autowired
        private TerminalService terminalService;

        /**
         *  Get records of terminal
         * @return
         * @throws Exception
         */
        @RequestMapping(method = RequestMethod.GET)
        @ResponseBody
        public List<Terminal> list() throws Exception{
            return  terminalService.list();
        }

        /**
         * Get 1 terminal record by id
         * @param tid
         * @return
         * @throws Exception
         */
        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        @ResponseBody
        public Terminal show(@PathVariable String tid)  throws Exception{
            return terminalService.show(tid);
        }


//        /**
//         *
//         * @throws Exception
//         */
//        @RequestMapping(value ="/create", method = RequestMethod.POST)
//        @ResponseBody
//        public void create() throws Exception{
//            terminalService.create();
//        }


    /**
     *
     * @param terminalDto
     * @param response
     * @throws Exception
     */
        @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
        public void create(@RequestBody TerminalDto terminalDto, HttpServletResponse response) throws Exception{
            String msg="";
            String data = "";
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode jsonNodes = mapper.createObjectNode();
            try{
                terminalService.create(terminalDto);
                msg="terminal created";
            }catch (Exception ex){
                msg = ex.getMessage();
//                msg = "terminal failed to create";
            }
            finally {
                jsonNodes.put("msg", msg);
                data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodes);
                response.getWriter().println(data);
            }
        }

        /**
         * Delete terminal by id
         * @param tid
         * @throws Exception
         */
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
        @ResponseBody
        public void delete( @RequestParam("id") String tid) throws Exception{
            terminalService.delete(tid);
        }
}

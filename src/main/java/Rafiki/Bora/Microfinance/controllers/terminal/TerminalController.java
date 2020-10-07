//package Rafiki.Bora.Microfinance.controllers.terminal;
//
//
//import Rafiki.Bora.Microfinance.model.terminal.Terminal;
//import Rafiki.Bora.Microfinance.service.terminalService.TerminalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//    @Controller
//    @RequestMapping("/terminal")
//    public class TerminalController {
//
//        @Autowired
//        private TerminalService terminalService;
//
//        /**
//         *  Get records of terminal
//         * @return
//         * @throws Exception
//         */
//        @RequestMapping(method = RequestMethod.GET)
//        @ResponseBody
//        public List<Terminal> list() throws Exception{
//            return  terminalService.list();
//        }
//
//        /**
//         * Get 1 terminal record by id
//         * @param id
//         * @return
//         * @throws Exception
//         */
//        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//        @ResponseBody
//        public Terminal show(@PathVariable String id)  throws Exception{
//            return terminalService.show(id);
//        }
//
//        /**
//         * Create new terminal
//         * @param deleted
//         * @param user
//         * @param merchant
//         * @throws Exception
//         */
//
//        @RequestMapping(method = RequestMethod.POST)
//        @ResponseBody
//        public void create( @RequestParam("deleted") Boolean deleted,
//                            @RequestParam("user") String user,
//                            @RequestParam("merchant") String merchant) throws Exception{
//            terminalService.create(deleted, user, merchant);
//        }
//
//        /**
//         * Update existing terminal
//         * @param deleted
//         * @param user
//         * @param merchant
//         * @throws Exception
//         */
//        @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//        @ResponseBody
//        public void update( @RequestParam("id") String id,
//                            @RequestParam("deleted") Boolean deleted,
//                            @RequestParam("user") String user,
//                            @RequestParam("merchant") String merchant) throws Exception{
//            terminalService.update(id, deleted, user, merchant);
//        }
//
//        /**
//         * Delete terminal by id
//         * @param id
//         * @throws Exception
//         */
//        @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//        @ResponseBody
//        public void delete( @RequestParam("id") String id) throws Exception{
//            terminalService.delete(id);
//        }
//}

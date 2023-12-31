<%-- 
    Document   : lesson
    Created on : Jul 3, 2023, 9:21:18 PM
    Author     : TTNhan
--%>

<%@page import="java.util.Collections"%>
<%@page import="com.swp_project_g4.Model.Answer"%>
<%@page import="com.swp_project_g4.Model.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.swp_project_g4.Model.Post"%>
<%@page import="com.swp_project_g4.Database.MoocDAO"%>
<%@page import="com.swp_project_g4.Model.Mooc"%>
<%@page import="com.swp_project_g4.Model.Lesson"%>
<%@page import="com.swp_project_g4.Service.CookieServices"%>
<%@page import="com.swp_project_g4.Model.User"%>
<%@page import="com.swp_project_g4.Model.Course"%>
<%@ page import="com.swp_project_g4.Database.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    //check user loggedIn
    User user = null;
    if (!CookieServices.checkUserLoggedIn(request.getCookies())) {
        request.getSession().setAttribute("error", "You must be logged in before enter this lesson!");
        response.sendRedirect("/login");
        return;
    } else {
        user = UserDAO.getUserByUsername(CookieServices.getUserName(request.getCookies()));
    }

    //check courseID
    Course course = null;
    try {
        course = CourseDAO.getCourse((int) request.getAttribute("courseID"));
        if (course == null) {
            request.getSession().setAttribute("error", "Not exist the course!");
            throw new Exception("Not exist course!");
        }
    } catch (Exception e) {
        response.sendRedirect("/");
        return;
    }

    Lesson lesson = null;
    //check exist lessonID
    try {
        int lessonID = (int) request.getAttribute("lessonID");
        lesson = LessonDAO.getLesson(lessonID);
        if (lesson == null) {
            request.getSession().setAttribute("error", "Not exist the lesson!");
            throw new Exception("Not exist lesson!");
        }
    } catch (Exception e) {
    }

    //get last lesson in the course
    if (lesson == null) {
        int lessonID = LessonDAO.getFirstUncompleteLessonID(user.getID(), course.getID());
        //if have no lesson in this course
        if (lessonID < 0) {
            request.getSession().setAttribute("error", "There is no lesson in this course!");
            response.sendRedirect("/");
            return;
        }
        lesson = LessonDAO.getLesson(lessonID);
    }

    Mooc mooc = com.swp_project_g4.Database.MoocDAO.getMooc(lesson.getMoocID());
    //check match lessonID with courseID
    if (mooc != null && mooc.getCourseID() != course.getID()) {
        request.getSession().setAttribute("error", "Not exist the this lesson in the course!");
        response.sendRedirect("/");
        return;
    }

    //check purchased course
    try {
        if (!CourseDAO.checkPurchasedCourse(user.getID(), course.getID())) {
            request.getSession().setAttribute("error", "You haven't purchased this course!");
            throw new Exception("Not purchased course yet!");
        }
    } catch (Exception e) {
        response.sendRedirect("/");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="head.jsp">
            <jsp:param name="title" value="Yojihan Study"/>
        </jsp:include>
        <link rel="stylesheet" href="/public/assets/css/lesson.css">
        <script src="https://www.youtube.com/iframe_api"></script>
    </head>

    <body>
        <!-- HEADER -->
        <%@include file="header.jsp" %>
        <!--END HEADER -->

        <div class="main">
            <!-- Left Side -->
            <div class="leftSide">

                <div class="lesson-main">
                    <%
                        switch (lesson.getType()) {
                            //type 0 -> video
                            //type 3 -> Youtube ID
                            case 0:
                            case 3: {
                                Post post = PostDAO.getPostByLessonID(lesson.getID());
                                %>
                    <%@include file="lesson/video.jsp" %>
                    <%
                            break;
                        }
                        case 1: {
                            Post post = PostDAO.getPostByLessonID(lesson.getID());
                    %>
                    <%@include file="lesson/post.jsp" %>
                    <%
                            break;
                        }
                        //type 2 -> quiz
                        case 2: {
                    %>
                    <%@include file="lesson/quiz.jsp" %>
                    <%                                break;
                            }
                        }
                        %>

                </div>

                <!--Info under lesson-->
                <%@include file="lesson/lessonInfo.jsp" %>

            </div>
            <!-- Right side -->

            <%@include file="lesson/rightMenu.jsp" %>

        </div>

        <%@include file="footer.jsp" %>

        <%@include file="foot.jsp" %>

        <script src="/public/assets/js/lesson.js"></script>
        <script src="<%out.print(request.getContextPath());
        %>/public/assets/js/option.js"></script>

        <%@include file="popUpMessage.jsp" %>

    </body>

</html>
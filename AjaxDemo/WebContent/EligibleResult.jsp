<%		
		int age = Integer.parseInt(request.getParameter("vage"));
		String qual = request.getParameter("vqual");
		String res = "not eligible";
		if (age >= 20 && age <= 45
				&& (qual.equals("be") || qual.equals("btech"))) {
			res = "eligible";
		}
		out.println(res);
	%>








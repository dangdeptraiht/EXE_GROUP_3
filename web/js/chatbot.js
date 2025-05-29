// Tự động lấy context path từ URL
const contextPath = "/" + window.location.pathname.split("/")[1];

fetch(`${contextPath}/chat-widget/chat-popup.html`)
    .then(res => res.text())
    .then(html => {
        const container = document.createElement('div');
        container.innerHTML = html;
        document.body.appendChild(container);

        // ? Thực thi script bên trong
        const scripts = container.querySelectorAll("script");
        scripts.forEach(script => {
            const newScript = document.createElement("script");
            if (script.src) {
                newScript.src = script.src;
            } else {
                newScript.textContent = script.textContent;
            }
            document.body.appendChild(newScript);
        });
    });







//---------------Nhúng lẻ từng trang---------------
//fetch('<%= request.getContextPath() %>/chat-widget/chat-popup.html')
//        .then(res => res.text())
//        .then(html => {
//            const container = document.createElement('div');
//            container.innerHTML = html;
//            document.body.appendChild(container);
//
//            // 👉 Lấy và chạy script bên trong popup
//            const scripts = container.querySelectorAll("script");
//            scripts.forEach(script => {
//                const newScript = document.createElement("script");
//                if (script.src) {
//                    newScript.src = script.src;
//                } else {
//                    newScript.textContent = script.textContent;
//                }
//                document.body.appendChild(newScript);
//            });
//        });
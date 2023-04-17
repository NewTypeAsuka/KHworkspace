const size = document.getElementById("size");
const color = document.getElementById("color");
const apply = document.getElementById("apply");
const content = document.getElementById("content");
const registration = document.getElementById("registration");
const result = document.getElementById("result");

apply.addEventListener("click", () => {
    content.style.color = color.value;
    content.style.fontSize = size.value + "px";
});

registration.addEventListener("click", () => {
    const p = document.createElement("p");
    p.innerText = content.value;

    const contentStyle = content.getAttribute("style");
    p.setAttribute("style", contentStyle);
    result.append(p);
});
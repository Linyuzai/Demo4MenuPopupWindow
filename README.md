# Demo4MenuPopupWindow
menu popupwindow

textView = (TextView) findViewById(R.id.tv);
popupWindow = MenuPopupWindow.Builder()
.setTitle("popup window")
.setMenuExtraHeight(35)
.addMenu("menu1", new Menu1ClickListener())
.addMenu("menu2", new Menu2ClickListener())
.addMenu("menu3", new Menu3ClickListener())
.create(this);
textView.setOnClickListener(new View.OnClickListener() {
@Override
  public void onClick(View v) {popupWindow.showFromBottom(textView);}
});

just for convenience

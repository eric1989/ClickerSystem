//
//  ViewController.m
//  ClickerSystem
//
//  Created by Rick Ieong on 4/5/14.
//  Copyright (c) 2014 Rick Ieong. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    NSURL *url = [NSURL URLWithString:@"http://zhoushuo.no-ip.biz"];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    [self.webView loadRequest:request];
    self.webView.ScalesPageToFit=YES;
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end

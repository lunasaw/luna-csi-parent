var icon_perf = '/metronic/assets/img/eap/ActiveView.gif';
var icon_server = '/metronic/assets/img/eap/base_disabled.gif';
var icon_cluster = '/metronic/assets/img/eap/workflow_16.gif';
var icon_war = '/metronic/assets/img/eap/war.gif';
var icon_service = '/metronic/assets/img/eap/sca_spring.gif';
var icon_workflow = '/metronic/assets/img/eap/workflow_16.gif';

var indexdata =
    [{
        text: 'openEAP', isexpand: true, children: [
            {
                text: '������', url: 'servers.html', isexpand: false, children: [
                    {url: 'server.html', text: '��������Ŀ', icon: icon_server},
                    {url: 'server.html', text: 'ʵսƽ̨��Ŀ', icon: icon_server}
                ]
            },
            {text: '��Ⱥ', url: ''},
            {
                text: '����', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��', icon: icon_war},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ', icon: icon_war}
                ]
            },
            {
                text: '����', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��', icon: icon_service},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ'}
                ]
            },
            {
                text: '��ȫ', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��'},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ'}
                ]
            },
            {
                text: '��־', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��'},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ'}
                ]
            },
            {
                text: '����', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��', icon: icon_workflow},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ', icon: icon_workflow}
                ]
            },
            {
                text: '����', isexpand: false, children: [
                    {url: '/demo/page/cmdb/org/roles.htm', text: 'Ӧ��', icon: icon_perf},
                    {url: '/demo/page/cmdb/org/roles.htm', text: '���� & ֹͣ', icon: icon_perf}
                ]
            }
        ]
    }
    ];
$('#tree').ligerTree({
    data: indexdata,
    checkbox: false,
    slide: false,
    nodeWidth: 114,
    attribute: ['nodename', 'url'],
    onSelect: function (node) {
        if (!node.data.url) return;
        $("#frame").attr("src", node.data.url);
    }
});